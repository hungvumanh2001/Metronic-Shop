package com.example.metronicshop.service;

import com.example.metronicshop.model.ReceiptDetail;

import java.util.List;

public interface ReceiptDetailService {
    List<ReceiptDetail> findAllByReceiptId(Long receiptId);
}
