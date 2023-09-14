// Function to add a selected product to the list
function addProduct() {
    const productSelect = document.getElementById("productSelect");
    const selectedProducts = document.getElementById("selectedProducts");
    const selectedProduct = productSelect.options[productSelect.selectedIndex].text;

    // Create a list item and add the selected product
    const listItem = document.createElement("li");
    listItem.textContent = selectedProduct;
    selectedProducts.appendChild(listItem);
}

// Define shipping costs for each product
const productShippingCosts = {
    product1: 50,  // Shipping cost for Banarasi Silk Sari
    product2: 75,  // Shipping cost for Cotton Kurta
    product3: 100  // Shipping cost for Silk Dupatta
};

// Function to calculate total cost and shipping cost
function calculateTotal() {
    // Get the selected product from the dropdown
    const productSelect = document.getElementById("productSelect");
    const selectedProduct = productSelect.options[productSelect.selectedIndex].value;

    // Get the quantity of the selected product
    const productQuantity = parseInt(document.getElementById("productQuantity").value);

    // Calculate the total cost of products based on quantity
    const productCost = calculateProductCost(selectedProduct, productQuantity);

    // Calculate the shipping cost based on the selected product
    const shippingCost = calculateShippingCost(selectedProduct);

    // Calculate the total order value
    const totalOrderValue = productCost + shippingCost;

    // Update the shipping cost and total order value fields in the form
    document.getElementById("shippingCost").value = shippingCost;
    document.getElementById("totalOrderValue").value = totalOrderValue;
}

// Function to calculate the cost of products based on quantity and product type
function calculateProductCost(selectedProduct, quantity) {
    // Define the cost per unit for each product
    const productCosts = {
        product1: 2000,  // Cost per unit for Banarasi Silk Sari
        product2: 2500,  // Cost per unit for Cotton Kurta
        product3: 3000   // Cost per unit for Silk Dupatta
    };

    // Calculate the total cost of the selected product
    const costPerUnit = productCosts[selectedProduct];
    return costPerUnit * quantity;
}

// Function to calculate the shipping cost based on the selected product
function calculateShippingCost(selectedProduct) {
    // If the order value is above 100000, no shipping cost is needed
    // Otherwise, use the predefined shipping cost for the selected product
    const orderValue = parseFloat(document.getElementById("totalOrderValue").value);
    if (orderValue >= 100000) {
        return 0; // No shipping cost
    } else {
        return productShippingCosts[selectedProduct];
    }
}

// Function to reset form fields
function resetForm() {
    const quoteForm = document.getElementById("quoteForm");
    quoteForm.reset();

    // After successfully creating the quote, display an alert
    alert("Quote is created!");

    // Additionally, clear the selected products list
    const selectedProducts = document.getElementById("selectedProducts");
    selectedProducts.innerHTML = "";
}

// Function to handle form submission
document.getElementById("quoteForm").addEventListener("submit", function (event) {
    event.preventDefault();

    // Get the selected order date
    const orderDateInput = document.getElementById("orderDate");
    
    const selectedDate = new Date(orderDateInput.value);

    // Get today's date
    const today = new Date();

    // Compare the selected date with today's date
    if (selectedDate < today) {
        alert("Error: Order date cannot be older than today.");
    } else {
        // Reset the form fields (you can define this function)
        resetForm();
    }
});
