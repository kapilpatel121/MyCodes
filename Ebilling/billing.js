document.addEventListener('DOMContentLoaded', function() {
    const form = document.querySelector('form');
    const tableBody = document.getElementById('billing_table_body');
    const totalAmount = document.getElementById('total_amount');
    const discountAmount = document.getElementById('discount_amount');
    const totalAfterDiscount = document.getElementById('total_after_discount');
    let totalPrice = 0;

    form.addEventListener('submit', function(event) {
        event.preventDefault();

        // Get values from the form
        const productId = document.getElementById('product_id').value;
        const productName = document.getElementById('product_name').value;
        const quantity = parseInt(document.getElementById('quantity').value);
        const price = parseFloat(document.getElementById('price').value);

        // Calculate total for this item
        const total = quantity * price;

        // Create a new row for the billing table
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${productId}</td>
            <td>${productName}</td>
            <td>${quantity}</td>
            <td>${price.toFixed(2)}</td>
            <td>${total.toFixed(2)}</td>
        `;

        // Append the row to the table body
        tableBody.appendChild(row);

        // Update total price
        totalPrice += total;
        totalAmount.textContent = totalPrice.toFixed(2);

        // Apply discount of 10%
        const discount = totalPrice * 0.1;
        const discountedTotal = totalPrice - discount;
        discountAmount.textContent = discount.toFixed(2);

        // Display the discounted total
        totalAfterDiscount.textContent = discountedTotal.toFixed(2);

        // Reset only the Product Details fields
        clearProductDetails();
    });

    // Function to clear Product Details fields
    function clearProductDetails() {
        document.getElementById('product_id').value = '';
        document.getElementById('product_name').value = '';
        document.getElementById('quantity').value = '';
        document.getElementById('price').value = '';
    }

    // Function to print the bill and send request
    document.getElementById('print_bill_button').addEventListener('click', function() {
        // Collect customer information (you can modify this to collect required data)
        const customerName = document.getElementById('customer_name').value;
        const contactNumber = document.getElementById('contact_number').value;
        const email = document.getElementById('email').value;
        const paymentMode = document.getElementById('payment_mode').value;
        const totalAmount = parseFloat(document.getElementById('total_amount').textContent);

        // Create an object with the customer data
        const customerData = {
            customerName: customerName,
            contactNumber: contactNumber,
            email: email,
            paymentMode: paymentMode,
            totalAmount: totalAmount
        };

        // Send a POST request to the server (you can replace the URL with your endpoint)
        fetch('http://localhost:4041/api/customers/addBill', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(customerData)
        }).then(response => {
            if (response.ok) {
                console.log("Bill printed successfully!");
                // Optionally, show a success message to the user
                alert("Bill printed successfully!");
            } else {
                console.error("Failed to print bill.");
                // Optionally, show an error message to the user
                alert("Failed to print bill. Please try again later.");
            }
        }).catch(error => {
            console.error("Error:", error);
            // Optionally, show an error message to the user
            alert("An error occurred. Please try again later.");
        });
    });
});
