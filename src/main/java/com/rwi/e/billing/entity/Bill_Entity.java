package com.rwi.e.billing.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "customer_bill_details")
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class Bill_Entity {

    @Id
    @SequenceGenerator(name = "billgen1", sequenceName = "Bill_no_seq1", initialValue = 101, allocationSize = 1)
    @GeneratedValue(generator = "billgen1", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "payment_type", nullable = false)
    @NonNull
    private String paymentType;

    @Column(name = "total_amount", nullable = false)
    @NonNull
    private Double totalAmount;

    @Column(name = "purchase_time", nullable = false)
    @CreationTimestamp
    private LocalDateTime purchaseTime;

    @Column(name = "product_count", nullable = false)
    @NonNull
    private Integer noOfProduct;

    @Column(name = "pdf_path", nullable = true)
    private String pdfPath;

    @ManyToOne
    @NonNull
    private Customer customer;
}
