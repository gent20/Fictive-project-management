package com.fictiveprojectmanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Product {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String dateTime;
    private int channelCode;
    private String transactionId;
    private int lineItemId;
    private double volume;
    private double salesIncVatActual;
    private double priceIncVat;
    private double priceIncVatOriginal;
    private BigDecimal upcCode;
    private String upcName;
    private String categoryName;
    private String subCategoryName;
    private String brandName;
    private String packageName;
    private String supplierName;
    private int numberOfTransactions;
    private String gender;
    private String customerSegment;
    private int terminalCheckRegister;
    private int zipCode;
    private String zipCodeExtend;
    private String zipCodeTotal;
    private String street;
    private int numOfEmployees;
    private int m2;
    private String storeSegment;
    private String region;
    private double marginOctober;
    private double priceIncVatOctober;
    private double discountOctober;
}
