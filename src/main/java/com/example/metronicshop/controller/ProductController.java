package com.example.metronicshop.controller;

import com.example.metronicshop.model.Product;
import com.example.metronicshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@CrossOrigin("*")
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping
    public ResponseEntity<Iterable<Product>> findAll()
    {
        Iterable<Product> products=productService.findAll();
        if(products==null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/search-by-cateId")
    public ResponseEntity<Iterable<Product>> findAllByCateId(@PageableDefault(size =12)Pageable pageable,@RequestParam Long id) {
        Iterable<Product> products=productService.findAllByCategoryId(pageable,id);
        if(products==null)
            return new ResponseEntity<>(products, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @GetMapping("/price-between")
    public ResponseEntity<Iterable<Product>>findAllByPriceBetween(@RequestParam float from,@RequestParam float to)
    {
        Iterable<Product> products=productService.findAllByPriceBetween(from,to);
        if(products==null)
            return new ResponseEntity<>(products, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    //bet sale tất cả những sản phẩm đc sale thì cho vào best sale
    @GetMapping("/sale-between")
    public ResponseEntity<Iterable<Product>>findAllBySaleBetween(@RequestParam float from,@RequestParam float to)
    {
        Iterable<Product> products=productService.findAllBySaleBetween(from,to);
        if(products==null)
            return new ResponseEntity<>(products, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
