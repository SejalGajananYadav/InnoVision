// Wait for the HTML document to be fully loaded before executing JavaScript
document.addEventListener("DOMContentLoaded", function() {
    // Get references to important elements in the HTML
    const loginForm = document.getElementById("login-form"); // The login form
    const passwordInput = document.getElementById("password"); // The password input field
    const passwordError = document.getElementById("password-error"); // Element to display password error message

    // Add an event listener to the login form when it's submitted
    loginForm.addEventListener("submit", function(event) {
        event.preventDefault(); // Prevent the form from submitting and refreshing the page

        // Replace with your hardcoded username and password
        const hardcodedUsername = "User1";
        const hardcodedPassword = "User1@123";

        // Get the values entered by the user for username and password
        const enteredUsername = loginForm.username.value;
        const enteredPassword = loginForm.password.value;

        // Check if the entered username and password match the hardcoded values
        if (enteredUsername === hardcodedUsername && enteredPassword === hardcodedPassword) {
            // Successful login, redirect to OrderMangementCustomer.html
            window.location.href = "../OrderManagementPages/OrderManagementCustomer.html";
        } else {
            // Display an error message if the username or password is incorrect
            passwordError.textContent = "Invalid username or password.";
        }
    });

    // Add an event listener to the password input field when user types
    passwordInput.addEventListener("input", function() {
        const enteredPassword = passwordInput.value;

        // Password validation logic (e.g., length, uppercase, lowercase, special characters)
        const isValidPassword = validatePassword(enteredPassword);

        if (!isValidPassword) {
            // Display an error message if the password does not meet the requirements
            passwordError.textContent = "Password does not meet the requirements.";
        } else {
            // Clear the error message if the password is valid
            passwordError.textContent = "";
        }
    });

    // Function to validate the password
    function validatePassword(password) {
        if (password.length < 8) {
            return false; // Password should be at least 8 characters long
        }
    
        // Check if the password contains at least one uppercase letter (A-Z).
        if (!/[A-Z]/.test(password)) {
            return false;
        }
    
        // Check if the password contains at least one lowercase letter (a-z).
        if (!/[a-z]/.test(password)) {
            return false;
        }
    
        // Check if the password contains at least one digit (0-9).
        if (!/[0-9]/.test(password)) {
            return false;
        }
        return true; // Password meets the requirements
    }
});
