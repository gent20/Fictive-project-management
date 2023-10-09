package com.example.fictiveprojectmanagement.controller;

import com.example.fictiveprojectmanagement.entity.Product;
import com.example.fictiveprojectmanagement.entity.task1.Task1Dto;
import com.example.fictiveprojectmanagement.entity.task1.Task2;
import com.example.fictiveprojectmanagement.entity.task1.Task3;
import com.example.fictiveprojectmanagement.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @PostMapping("/products/saveAll")
    public List<Product> saveProducts(@RequestBody List<Product> productDtos){
        return productRepository.saveAll(productDtos);
    }

    @GetMapping("/products/firstTask")
    public List<Task1Dto> getTask1(){
        return productRepository.getTask1();
    }
    @GetMapping("/products/secondTask")
    public List<Task2> getTask2(){
        return productRepository.getTask2();
    }
    @GetMapping("/products/thirdTask")
    public List<Task3> getTask3(){
        return productRepository.getTask3();
    }
}
