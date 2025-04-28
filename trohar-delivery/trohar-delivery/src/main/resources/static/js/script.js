const userArea = document.getElementById("user-area");
const loggedUser = localStorage.getItem("loggedInUser");
const currentPage = window.location.pathname.split("/").pop();
let allRestaurants = JSON.parse(localStorage.getItem("restaurants") || "[]");
let allOrders = JSON.parse(localStorage.getItem("orders") || "[]");
const csrfToken = document.querySelector('meta[name="_csrf"]')?.content;
const csrfHeader = document.querySelector('meta[name="_csrf_header"]')?.content;

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
      <a href="login" class="btn small">Вход</a>
      <a href="signup" class="btn small">Регистрация</a>
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
document.addEventListener('DOMContentLoaded', function() {
    const form = document.getElementById("signup-form");

    if (form) {
        form.addEventListener("submit", async function(e) {

            e.preventDefault();

            const fullname = document.getElementById("fullname").value;
            const newUsername = document.getElementById("newUsername").value;
            const newPassword = document.getElementById("newPassword").value;
            const repeatPassword = document.getElementById("repeatPassword").value;
            const role = document.getElementById("role").value;

            // Password mismatch check
            if (newPassword !== repeatPassword) {
                alert("Паролите не съвпадат.");
                return;
            }

            try {
                // Sending data to the server via POST request
                const response = await fetch("/signup", {
                    method: "POST",
                    headers: {
                        [csrfHeader]: csrfToken,
                        "Content-Type": "application/x-www-form-urlencoded"
                    },
                    body: `fullname=${encodeURIComponent(fullname)}&newUsername=${encodeURIComponent(newUsername)}&newPassword=${encodeURIComponent(newPassword)}&role=${encodeURIComponent(role)}`
                });

                // Check if the response is successful
                if (response.ok) {
                    alert("Регистрация успешна! Пренасочваме ви към входа...");
                    setTimeout(() => {
                        window.location.href = "/login";  // Redirecting to login page
                    }, 1500);
                } else {
                    // If there's an error from the server
                    const errorMessage = await response.text();
                    alert(errorMessage);  // Show server error message in an alert
                }
            } catch (error) {
                // In case of network or other errors
                console.error("Sign-up error:", error);
                alert("Възникна грешка. Моля, опитайте отново.");
            }
        });
    } else {
        console.error("Signup form not found");
    }
});


// --- Вход ---
document.addEventListener('DOMContentLoaded', function () {
  const loginForm = document.getElementById('login-form');

  if (loginForm) {
    loginForm.addEventListener('submit', async function (event) {
      event.preventDefault();

      const usernameField = document.getElementById("username");
      const passwordField = document.getElementById("password");

      const username = usernameField.value.trim();
      const password = passwordField.value;

      try {
        const formData = new URLSearchParams();
        formData.append('username', username);
        formData.append('password', password);

        const response = await fetch('/login', {
          method: 'POST',
          headers: {
            [csrfHeader]: csrfToken,
            'Content-Type': 'application/x-www-form-urlencoded'
          },
          body: formData
        });

        if (response.redirected) {
          window.location.href = response.url;
        } else {
          const html = await response.text();
          document.body.innerHTML = html;
          alert('Грешно потребителско име или парола.');
        }
      } catch (error) {
        console.error('Login failed:', error);
      }
    });
  }
});

// --- Зареждане на менюто ---
document.addEventListener('DOMContentLoaded', async function () {
  try {
    const response = await fetch('/menu/api/menu');
    const menuItems = await response.json();

    const menuContainer = document.getElementById('menu-items');
    if (!menuContainer) {
      console.error('Menu container not found!');
      return;
    }

    menuContainer.innerHTML = ''; // Clear any existing content

    if (menuItems.length === 0) {
      menuContainer.innerHTML = '<p>Няма налични продукти в менюто.</p>';
      return;
    }

    menuItems.forEach(item => {
      const menuItemDiv = document.createElement('div');
      menuItemDiv.classList.add('menu-item');

      menuItemDiv.innerHTML = `
        <h3>${item.name}</h3>
        <p>${item.description}</p>
        <p><strong>Цена:</strong> ${item.price} лв</p>
        <button class="btn add-to-cart" data-item-id="${item.id}">Добави в кошницата</button>
      `;

      menuContainer.appendChild(menuItemDiv);
    });
  } catch (error) {
    console.error('Error loading menu items:', error);
    const menuContainer = document.getElementById('menu-items');
    if (menuContainer) {
      menuContainer.innerHTML = '<p>Неуспешно зареждане на менюто. Моля, опитайте отново.</p>';
    }
  }
});


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

