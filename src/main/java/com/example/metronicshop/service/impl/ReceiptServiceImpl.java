package com.example.metronicshop.service.impl;

import com.example.metronicshop.model.Receipt;
import com.example.metronicshop.model.ReceiptDetail;
import com.example.metronicshop.repository.ReceiptRepository;
import com.example.metronicshop.repository.UserRepository;
import com.example.metronicshop.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

@Service
public class ReceiptServiceImpl implements ReceiptService {
    @Autowired
    ReceiptRepository receiptRepository;
    @Autowired
    UserRepository userRepository;
    @Override
    public void save(Receipt model) {
        Receipt receipt = new Receipt();
        if(model.getUser()!=null && model.getUser().getId()!=null){
            receipt.setUser(userRepository.getOne(model.getUser().getId()));
        }
        receipt.setFullname(model.getFullname());
        receipt.setStatus(model.getStatus());
        receipt.setSdt(model.getSdt());
        receipt.setAddress(model.getAddress());
        receipt.setPriceTotal(model.getPriceTotal());
        receipt.setDate(new Date());
        if(model.getReceiptDetails()!=null){
            Iterator<ReceiptDetail> iters = model.getReceiptDetails().iterator();
            HashSet<ReceiptDetail> receiptDetails = new HashSet<ReceiptDetail>();
            while (iters.hasNext()){
                ReceiptDetail receiptDetailIters = iters.next();
                ReceiptDetail receiptDetail = new ReceiptDetail();
                receiptDetail.setReceipt(receipt);
                if(receiptDetailIters.getProduct()!=null){
                    receiptDetail.setProduct(receiptDetailIters.getProduct());
                }
                receiptDetail.setNumber(receiptDetailIters.getNumber());
                receiptDetail.setStatus(receiptDetailIters.getStatus());
                receiptDetails.add(receiptDetail);
            }
            receipt.setReceiptDetails(receiptDetails);
        }
        receiptRepository.save(receipt);
    }
}
