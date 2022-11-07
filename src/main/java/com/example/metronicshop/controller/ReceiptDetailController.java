package com.example.metronicshop.controller;

import com.example.metronicshop.model.Receipt;
import com.example.metronicshop.service.ReceiptDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/receipt-details")
@CrossOrigin("*")
public class ReceiptDetailController {
    @Autowired
    ReceiptDetailService receiptDetailService;

    @GetMapping("/find-all-by-receipt")
    public ResponseEntity<List<Receipt>> findAllByUser(@RequestParam Long receiptId) {
        return new ResponseEntity(receiptDetailService.findAllByReceiptId(receiptId), HttpStatus.OK);
    }
}
