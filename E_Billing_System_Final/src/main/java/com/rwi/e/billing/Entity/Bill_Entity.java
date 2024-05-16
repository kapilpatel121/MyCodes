package com.rwi.e.billing.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name = "Bill_Details")
public class Bill_Entity {
	
	@Id
	@SequenceGenerator(name = "billgen1",sequenceName = "Bill_no_seq1",initialValue =101,allocationSize = 1 )
	@GeneratedValue(generator = "billgen1",strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Email_Id", nullable = false)
    private String email;

    @Column(name = "Contact_Number", nullable = false)
    private String contactNo; // Corrected field name

    @Column(name = "Payment_Type", nullable = false)
    private String paymentType;

    @Column(name = "Total_Amount", nullable = false) // Corrected field name
    private Double totalAmount;

    @Column(name = "transaction_Id", nullable = true)
    private String transactionId;

    @Column(name = "Purchase_Time", nullable = true)
    private LocalDateTime purchaseTime=LocalDateTime.now();
  
    @Column(name = "Product_Count", nullable = true)
    private Integer noOfProduct;
  
    @Column(name = "pdfPath", nullable = true)
    private String pdfPath;
    
    

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public LocalDateTime getPurchaseTime() {
		return purchaseTime;
	}

	public void setPurchaseTime(LocalDateTime purchaseTime) {
		this.purchaseTime = purchaseTime;
	}

	public String getPdfPath() {
		return pdfPath;
	}

	public void setPdfPath(String pdfPath) {
		this.pdfPath = pdfPath;
	}

	public Integer getNoOfProduct() {
		return noOfProduct;
	}

	public void setNoOfProduct(Integer noOfProduct) {
		this.noOfProduct = noOfProduct;
	}
}
