package com.example.metronicshop.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class ReceiptDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Receipt receipt;
    @ManyToOne
    private Product product;

    private int number;

    private int status;

    public ReceiptDetail() {
    }

    public ReceiptDetail(Long id, Receipt receipt, Product product, int status, int number) {
        this.id = id;
        this.receipt = receipt;
        this.product = product;
        this.status = status;
        this.number = number;
    }
    public ReceiptDetail(ReceiptDetail entity, boolean collapse) {
        this.id = entity.getId();
        this.receipt = new Receipt(entity.getReceipt(), true);
        this.product = entity.getProduct();
        this.status = entity.getStatus();
        this.number = entity.getNumber();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
