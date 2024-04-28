import axios from 'axios';
import React, { useEffect, useState } from 'react';
import './billing.css';

function BillingPage() {
    const [formData, setFormData] = useState({
        customer_name: '',
        contact_number: '',
        email: '',
        payment_mode: 'cash',
        product_id: '',
        product_name: '',
        quantity: '',
        price: ''
    });

    const [products, setProducts] = useState([]);
    const [billingItems, setBillingItems] = useState([]);
    const [totalPrice, setTotalPrice] = useState(0);

    useEffect(() => {
        fetchProductNames();
    }, []);

    const fetchProductNames = async () => {
        try {
            const response = await axios.get('http://localhost:4041/api/customers/getProduct');
            const data = response.data;
            setProducts(data);
        } catch (error) {
            console.error('Error fetching product names:', error);
        }
    };

    const handleChange = async (e) => {
        const { name, value } = e.target;
        setFormData({
            ...formData,
            [name]: value
        });
        if (name === 'product_name') {
            try {
                const response = await axios.getget(`http://localhost:4041/api/customers/getProductDetails?productName=${value}`);
                const { productId, price } = response.data;
                setFormData({
                    ...formData,
                    product_id: productId,
                    price: price
                });
            } catch (error) {
                console.error('Error fetching product details:', error);
            }
        }
    };

    const handleSubmit = (e) => {
        e.preventDefault();

        const total = parseFloat(formData.quantity) * parseFloat(formData.price);
        const newItem = { ...formData, total: total.toFixed(2) };

        setBillingItems([...billingItems, newItem]);
        setTotalPrice(totalPrice + total);

        clearProductDetails();
    };

    const clearProductDetails = () => {
        setFormData({
            ...formData,
            product_id: '',
            quantity: '',
            price: ''
        });
    };

    const printBill = async () => {
        try {
            const response = await axios.post('http://localhost:4041/api/customers/addBill', {
                customerName: formData.customer_name,
                contactNumber: formData.contact_number,
                email: formData.email,
                paymentMode: formData.payment_mode,
                totalAmount: totalPrice
            });
            if (response.data === 'Bill added successfully') {
                console.log("Bill printed successfully!");
                alert("Bill printed successfully!");
            } else {
                throw new Error('Failed to print bill');
            }
        } catch (error) {
            console.error("Error:", error);
            alert("An error occurred. Please try again later.");
        }
    }

    return (
        <div className="container">
            <h2>Billing Information</h2>
            <form onSubmit={handleSubmit}>
                <div className="form-group">
                    <div className="input-group">
                        <label htmlFor="customer_name">Customer Name:</label>
                        <input type="text" id="customer_name" name="customer_name" value={formData.customer_name} onChange={handleChange} required />
                    </div>
                    <div className="input-group">
                        <label htmlFor="contact_number">Contact Number:</label>
                        <input type="text" id="contact_number" name="contact_number" value={formData.contact_number} onChange={handleChange} required />
                    </div>
                    <div className="input-group">
                        <label htmlFor="email">Email:</label>
                        <input type="text" id="email" name="email" value={formData.email} onChange={handleChange} required />
                    </div>
                    <div className="input-group">
                        <label htmlFor="payment_mode">Payment Mode:</label>
                        <select id="payment_mode" name="payment_mode" value={formData.payment_mode} onChange={handleChange}>
                            <option value="cash">Cash</option>
                            <option value="credit_card">Credit Card</option>
                            <option value="debit_card">Debit Card</option>
                            <option value="UPI">UPI</option>
                        </select>
                    </div>
                    <div className="input-group">
                        <label htmlFor="product_name">Product Name:</label>
                        <select id="product_name" name="product_name" value={formData.product_name} onChange={handleChange} required>
                            <option value="">Select a product</option>
                            {products && products.map((product, index) => (
                                <option key={index} value={product}>{product}</option>
                            ))}
                        </select>
                    </div>
                    <div className="input-group">
                        <label htmlFor="quantity">Quantity:</label>
                        <input type="number" id="quantity" name="quantity" min="1" value={formData.quantity} onChange={handleChange} required />
                    </div>
                    <div className="input-group">
                        <label htmlFor="product_id">Product Id:</label>
                        <input type="number" id="product_id" name="product_id" min="1" value={formData.product_id} onChange={handleChange} />
                    </div>
                    <div className="input-group">
                        <label htmlFor="price">Price:</label>
                        <input type="number" id="price" name="price" min="0.01" step="0.01" value={formData.price} onChange={handleChange} required />
                    </div>
                </div>
                <div className="input-group input-group-submit">
                    <input type="submit" value="Add Item" />
                </div>
            </form>
            <h2>Billing Table</h2>
            <table>
                <thead>
                    <tr>
                        <th>Product ID</th>
                        <th>Product Name</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Total</th>
                    </tr>
                </thead>
                <tbody>
                    {billingItems.map((item, index) => (
                        <tr key={index}>
                            <td>{item.product_id}</td>
  
                          <td>{item.product_name}</td>
                            <td>{item.quantity}</td>
                            <td>{item.price}</td>
                            <td>{item.total}</td>
                        </tr>
                    ))}
                </tbody>
                <tfoot>
                    <tr className="total">
                        <td colSpan="4">Total</td>
                        <td>{totalPrice.toFixed(2)}</td>
                    </tr>
                </tfoot>
            </table>
            <div className="print-bill-box">
                <button id="print_bill_button" onClick={printBill}>Print Bill</button>
            </div>
        </div>
    );
}

export default BillingPage;
