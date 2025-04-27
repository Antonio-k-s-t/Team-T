const cartURL = 'http://trohar-delivery.bg/cart';

//add elements
async function addToCart(customerID, productID){
    try{
        const response = await fetch(cartURL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({customerID, productID})
        });

        if(response.ok)
        {
            const data = await response.json();
            alert('This item has been added to the cart!');

            showCartItems();
        }
        else{
            const errorData = await response.json();
            alert('Cannot add item to the cart');
        }
    }catch(error)
    {
        console.error('Error during accessing profile:', error);
    }
}
//show elements
async function showCartItems(customerID){
    try{
        const response = await fetch(cartURL, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({customerID})
        });

        if(response.ok)
        {
            const data = await response.json();
            const cartItems = data.cartItems;

            const cartC = document.getElementsByClassName();

            function cartCounter()
            {
                //TODO: логика на брояча
            }

            if(cartItems.lenght === 0)
                {
                    cartC.innerHTML = '<p>Your cart is empty</p>';
                }
                else{
                    cartItems.forEach(item => {
                        const itemElement = document.createElement('div');
                        itemElement.className = 'cart-item';
                        itemElement.innerHTML = '<p></p>';//TODO: да се добавят на елементите
                    });
                }
        }
        else{
            alert('Could not fetch cart items');
        }
    }catch(error)
    {
        console.error('Error fetching the items:', error);
        alert('An error ocurred while retrieving the data.');
    }
}
//remove elements
const removeURL = 'http://trohar-delivery.bg/cart/${productId}';
async function removeFromCart(customerID, itemID){
    try{
        const response = await fetch(removeURL, {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({customerID, itemID})
        });

        if(response.ok)
        {
            const data = await response.json();
            alert('The item has been removed from the cart!');

            showCartItems(userID);
        }
        else{
            const errorData = await response.json();
            alert('Cannot remove item from the cart');
        }
    }catch(error)
    {
        console.error('Error during removal of items.', error);
        alert('Something went wrong. Can not remove item from the list!');
    }
}
