package com.codegym.freshfood.controller;

import com.codegym.freshfood.model.Product;
import com.codegym.freshfood.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/product")
public class ProductController {
  @Autowired
  ProductService productService;

  @GetMapping("/home")
  public ResponseEntity<Iterable<Product>> showListProduct(){
    System.out.println("ok");
//    try {
      Iterable<Product> products = productService.findAllProduct();
      for (Product product: products){
        System.out.println(product.getPicture().size());
//        System.out.println(product.getCategory().toString());
      }


        System.out.println(products);
        return new ResponseEntity<Iterable<Product>>(products,HttpStatus.OK);
//    }catch (Exception e){
//      return new ResponseEntity(HttpStatus.NOT_FOUND);
//    }
  }


  @PostMapping("/add")
//  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity addNewProduct(@Valid @RequestBody Product product){
    try {
      productService.save(product);
      return new ResponseEntity(HttpStatus.CREATED);
    }catch (Exception e){
      return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
  }
}
