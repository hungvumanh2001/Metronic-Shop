package com.example.metronicshop.service;

import com.example.metronicshop.model.Receipt;

import java.util.List;

public interface ReceiptService {
    void save(Receipt receipt);
    List<Receipt> findAllByUserId(Long userId);
}
