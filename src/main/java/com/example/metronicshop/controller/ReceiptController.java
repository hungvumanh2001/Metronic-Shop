package com.example.metronicshop.controller;

import com.example.metronicshop.model.Cart;
import com.example.metronicshop.model.Receipt;
import com.example.metronicshop.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@Controller
@RequestMapping("/receipts")
@CrossOrigin("*")
public class ReceiptController {
    private static Logger logger = Logger.getLogger(String.valueOf(ReceiptController.class));
    @Autowired
    ReceiptService receiptService;

    @PostMapping("/add-receipt")
    public ResponseEntity save(@RequestBody Receipt receipt) {
        receiptService.save(receipt);
        logger.info("Save product to receipt");
        return new ResponseEntity(HttpStatus.OK);
    }


}
