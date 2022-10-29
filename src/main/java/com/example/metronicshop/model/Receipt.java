package com.example.metronicshop.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Receipt {
    //khi người dùng đặt hàng sẽ vào bảng này
    //status bawnfg2 là ng bán đã xác nhận đơn hàng
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    //mã hóa đơn nếu ng dùng thanh toán
    //còn k có thì nó chỉ là cart mà thôi
    @OneToMany(mappedBy = "receipt", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<ReceiptDetail> receiptDetails = new HashSet<ReceiptDetail>();

    private String fullname;
    private String sdt;

    private String address;

    private int status;
    private Long priceTotal;
    private Date date;

    public Receipt() {
    }

    public Receipt(Long id, User user, Set<ReceiptDetail> receiptDetails, String fullname, String sdt, String address, int status, Long priceTotal, Date date) {
        this.id = id;
        this.user = user;
        this.receiptDetails = receiptDetails;
        this.fullname = fullname;
        this.sdt = sdt;
        this.address = address;
        this.status = status;
        this.priceTotal = priceTotal;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<ReceiptDetail> getReceiptDetails() {
        return receiptDetails;
    }

    public void setReceiptDetails(Set<ReceiptDetail> receiptDetails) {
        this.receiptDetails = receiptDetails;
    }

    public long getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(long priceTotal) {
        this.priceTotal = priceTotal;
    }

    public void setPriceTotal(Long priceTotal) {
        this.priceTotal = priceTotal;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
