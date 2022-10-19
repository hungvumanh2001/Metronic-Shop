package com.example.metronicshop.model;

import javax.persistence.*;

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

    private String sdt;

    private int status;

    public Receipt() {
    }

    public Receipt(Long id, User user, String sdt, int status) {
        this.id = id;
        this.user = user;

        this.sdt = sdt;

        this.status = status;
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

}
