function importProducts() {
    // Get references to the HTML elements we'll work with
    const fileInput = document.getElementById("fileInput"); // Input element for selecting a file
    const importStatus = document.getElementById("importStatus"); // Element to display import status

    // Get the selected file from the file input
    const file = fileInput.files[0];

    if (file) {
        // If a file is selected, simulate a server response after a delay
        setTimeout(() => {
            importStatus.textContent = "Status: Completed, Imported 10 products.";
        }, 2000); // Simulating a delay of 2000 milliseconds (2 seconds)
    } else {
        // If no file is selected, display a message to prompt the user to select a file
        importStatus.textContent = "Please select a file to upload.";
    }
}
