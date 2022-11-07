package com.example.metronicshop.service.impl;

import com.example.metronicshop.model.ReceiptDetail;
import com.example.metronicshop.repository.ReceiptDetailRepository;
import com.example.metronicshop.service.ReceiptDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceiptDetailServiceImpl implements ReceiptDetailService {
    @Autowired
    ReceiptDetailRepository receiptDetailRepository;

    @Override
    public List<ReceiptDetail> findAllByReceiptId(Long receiptId) {
        return receiptDetailRepository.findAllByReceiptId(receiptId);
    }
}
