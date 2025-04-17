const userArea = document.getElementById("user-area");
const loggedUser = localStorage.getItem("loggedInUser");
const currentPage = window.location.pathname.split("/").pop();
let allRestaurants = JSON.parse(localStorage.getItem("restaurants") || "[]");
let allOrders = JSON.parse(localStorage.getItem("orders") || "[]");
// --- Навигация: Покажи потребител или бутони ---
if (userArea) {
  if (loggedUser) {
    const userData = JSON.parse(localStorage.getItem("user_" + loggedUser));
    userArea.innerHTML = `
      <img src="images/user-icon.png" alt="User Icon" />
      <a href="profile.html"><span>${loggedUser}</span></a>
      <a href="#" id="logoutBtn" class="btn small">Изход</a>
    `;
    document.getElementById("logoutBtn").addEventListener("click", () => {
      localStorage.removeItem("loggedInUser");
      alert("Излезе успешно.");
      window.location.href = "index.html";
    });
  } else {
    userArea.innerHTML = `
      <a href="login.html" class="btn small">Вход</a>
      <a href="signup.html" class="btn small">Регистрация</a>
    `;
  }
}

// --- Защита на страници според роля ---
const protectedPages = {
  "menu.html": "client",
  "cart.html": "client",
  "employee.html": "employee",
  "restaurant.html": "restaurant"
};

if (protectedPages[currentPage]) {
  if (!loggedUser) {
    alert("Моля, влезте в профила си.");
    window.location.href = "login.html";
  } else {
    const userData = JSON.parse(localStorage.getItem("user_" + loggedUser));
    if (userData.role !== protectedPages[currentPage]) {
      alert("Нямате достъп до тази страница.");
      window.location.href = "index.html";
    }
  }
}
// --- Регистрация ---
const signupForm = document.getElementById("signup-form");
if (signupForm) {
  signupForm.addEventListener("submit", (e) => {
    e.preventDefault();
    const fullName = document.getElementById("fullname").value.trim();
    const username = document.getElementById("newUsername").value.trim();
    const password = document.getElementById("newPassword").value;
    const repeat = document.getElementById("repeatPassword").value;
    const role = document.getElementById("role").value;

    if (!fullName || !username || !password || !repeat || !role) {
      alert("Моля, попълнете всички полета.");
      return;
    }

    if (password !== repeat) {
      alert("Паролите не съвпадат.");
      return;
    }

    const userData = { fullName, username, password, role };
    localStorage.setItem("user_" + username, JSON.stringify(userData));
    localStorage.setItem("loggedInUser", username);

    alert("Успешна регистрация!");
    window.location.href = "index.html";
  });
}

// --- Вход ---
const loginForm = document.getElementById("login-form");
if (loginForm) {
  loginForm.addEventListener("submit", (e) => {
    e.preventDefault();
    const username = document.getElementById("username").value.trim();
    const password = document.getElementById("password").value;

    const userData = JSON.parse(localStorage.getItem("user_" + username));
    if (!userData || userData.password !== password) {
      alert("Грешно потребителско име или парола.");
      return;
    }

    localStorage.setItem("loggedInUser", username);
    alert("Добре дошъл, " + userData.fullName);

    // Пренасочване според роля
    if (userData.role === "client") {
      window.location.href = "menu.html";
    } else if (userData.role === "employee") {
      window.location.href = "employee.html";
    } else if (userData.role === "restaurant") {
      window.location.href = "restaurant.html";
    } else {
      window.location.href = "index.html";
    }
  });
}
// --- Зареждане на менюто ---
if (document.getElementById("menu-items")) {
  let html = "";
  allRestaurants.forEach(r => {
    html += `<h3>${r.name}</h3>`;
    r.products.forEach(p => {
      html += `
        <div class="menu-item">
          <h4>${p.name}</h4>
          <p>${p.price.toFixed(2)} лв</p>
          <button onclick="addToCart('${p.name}', ${p.price}, '${r.name}')" class="btn">Добави</button>
        </div>
      `;
    });
  });
  document.getElementById("menu-items").innerHTML = html;
}

// --- Добавяне към количка ---
function addToCart(name, price, restaurant) {
  let cart = JSON.parse(localStorage.getItem("cart")) || [];
  cart.push({ name, price, restaurant });
  localStorage.setItem("cart", JSON.stringify(cart));
  alert(`${name} добавено в кошницата.`);
}

// --- Показване на количката ---
function showCart() {
  const list = document.getElementById("cart-items");
  const total = document.getElementById("total");
  if (!list || !total) return;

  const cart = JSON.parse(localStorage.getItem("cart")) || [];
  list.innerHTML = "";
  let sum = 0;

  cart.forEach(item => {
    const li = document.createElement("li");
    li.textContent = `${item.name} - ${item.price.toFixed(2)} лв`;
    list.appendChild(li);
    sum += item.price;
  });

  total.textContent = `Общо: ${sum.toFixed(2)} лв`;
}

window.addEventListener("DOMContentLoaded", showCart);

// --- Изчистване на количка ---
const clearBtn = document.getElementById("clear-cart");
if (clearBtn) {
  clearBtn.addEventListener("click", () => {
    localStorage.removeItem("cart");
    showCart();
    alert("Кошницата е изчистена.");
  });
}

// --- Поръчка ---
const orderBtn = document.getElementById("place-order");
if (orderBtn) {
  orderBtn.addEventListener("click", () => {
    const cart = JSON.parse(localStorage.getItem("cart")) || [];
    if (!cart.length) return alert("Кошницата е празна.");

    const orders = JSON.parse(localStorage.getItem("orders") || "[]");
    orders.push({
      client: loggedUser,
      items: cart,
      created: new Date().toISOString()
    });

    localStorage.setItem("orders", JSON.stringify(orders));
    localStorage.removeItem("cart");
    showCart();
    alert("Поръчката е изпратена успешно!");
  });
}
// --- Добавяне на ресторант ---
if (document.getElementById("add-restaurant-form")) {
  const restForm = document.getElementById("add-restaurant-form");
  const restList = document.getElementById("restaurantList");

  restForm.addEventListener("submit", (e) => {
    e.preventDefault();
    const name = document.getElementById("restaurantName").value.trim();
    if (!name) return;

    allRestaurants.push({ name, products: [] });
    localStorage.setItem("restaurants", JSON.stringify(allRestaurants));
    alert("Ресторантът е добавен.");
    location.reload();
  });

  // Показване на ресторантите
  restList.innerHTML = "";
  allRestaurants.forEach((r, i) => {
    const li = document.createElement("li");
    li.innerHTML = `
      <strong>${r.name}</strong>
      <button onclick="deleteRestaurant(${i})" class="btn small">Изтрий</button>
    `;
    restList.appendChild(li);
  });
}

function deleteRestaurant(index) {
  allRestaurants.splice(index, 1);
  localStorage.setItem("restaurants", JSON.stringify(allRestaurants));
  alert("Ресторантът и продуктите му са изтрити.");
  location.reload();
}

// --- Добавяне на продукт към ресторант ---
if (document.getElementById("add-product-form")) {
  const select = document.getElementById("restaurantSelect");

  allRestaurants.forEach((r, i) => {
    const opt = document.createElement("option");
    opt.value = i;
    opt.textContent = r.name;
    select.appendChild(opt);
  });

  document.getElementById("add-product-form").addEventListener("submit", (e) => {
    e.preventDefault();
    const name = document.getElementById("productName").value.trim();
    const price = parseFloat(document.getElementById("productPrice").value);
    const restaurantIndex = parseInt(select.value);

    if (!name || isNaN(price)) return;

    allRestaurants[restaurantIndex].products.push({ name, price });
    localStorage.setItem("restaurants", JSON.stringify(allRestaurants));
    alert("Продуктът е добавен.");
    location.reload();
  });
}
// --- Страница на ресторант: виж поръчките ---
if (currentPage === "restaurant.html" && loggedUser) {
  const orderList = document.getElementById("orderList");
  const myData = JSON.parse(localStorage.getItem("user_" + loggedUser));

  const myOrders = allOrders.filter(order =>
    order.items.some(i => {
      return allRestaurants.some(r =>
        r.name === myData.fullName && r.products.some(p => p.name === i.name)
      );
    })
  );

  if (orderList) {
    if (myOrders.length === 0) {
      orderList.innerHTML = `<li>Няма нови поръчки.</li>`;
    } else {
      myOrders.forEach((o) => {
        const li = document.createElement("li");
        li.innerHTML = `
          <p><strong>От:</strong> ${o.client}</p>
          <p><strong>Продукти:</strong> ${o.items.map(i => i.name).join(", ")}</p>
          <p><strong>Дата:</strong> ${new Date(o.created).toLocaleString()}</p>
          <hr />
        `;
        orderList.appendChild(li);
      });
    }
  }
}

