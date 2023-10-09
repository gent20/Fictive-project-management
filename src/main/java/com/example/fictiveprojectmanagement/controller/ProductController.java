package com.example.fictiveprojectmanagement.controller;

import com.example.fictiveprojectmanagement.entity.Product;
import com.example.fictiveprojectmanagement.model.FirstTask;
import com.example.fictiveprojectmanagement.model.SecondTask;
import com.example.fictiveprojectmanagement.model.ThirdTask;
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
    public List<FirstTask> getTask1(){
        return productRepository.getFirstTask();
    }
    @GetMapping("/products/secondTask")
    public List<SecondTask> getTask2(){
        return productRepository.getSecondTask();
    }
    @GetMapping("/products/thirdTask")
    public List<ThirdTask> getTask3(){
        return productRepository.getThirdTask();
    }
}
