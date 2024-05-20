package com.rwi.e.billing.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "customer_details")
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @SequenceGenerator(name = "Custgen", sequenceName = "Cust_no_seq1", initialValue = 2001, allocationSize = 1)
    @GeneratedValue(generator = "Custgen", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "customer_name", nullable = false)
    @NonNull
    private String customerName;

    @Column(name = "email_id", nullable = false)
    @NonNull
    private String email;

    @Column(name = "contact_no", nullable = false)
    @NonNull
    private String phoneNo;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Bill_Entity> bills;
}
