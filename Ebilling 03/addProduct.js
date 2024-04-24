document.getElementById('productForm').addEventListener('submit', function(event) {
    event.preventDefault();
    
    const form = document.getElementById('productForm');
    const formData = new FormData(form);
    const productData = {};
    formData.forEach((value, key) => {
        productData[key] = value;
    });

    // Send AJAX request to Spring Boot application
    fetch('http://localhost:4041/rwi/ebill/api/addProduct', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(productData)
    })
    .then(response => {
        if (response.ok) {
            console.log('Product registered successfully!');
            alert('Product registered successfully!');
            // Clear the form fields
            form.reset();
        } else {
            console.error('Failed to register product.');
            alert('Failed to register product. Please try again later.');
        }
    })
    .catch(error => {
        console.error('Error:', error);
        alert('An error occurred. Please try again later.');
    });
});
