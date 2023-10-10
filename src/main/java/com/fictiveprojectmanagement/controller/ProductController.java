package com.fictiveprojectmanagement.controller;

import com.fictiveprojectmanagement.entity.Product;
import com.fictiveprojectmanagement.model.FirstTask;
import com.fictiveprojectmanagement.model.SecondTask;
import com.fictiveprojectmanagement.model.ThirdTask;
import com.fictiveprojectmanagement.repository.ProductRepository;
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
    public List<FirstTask> getFirstTask(){
        return productRepository.getFirstTask();
    }
    @GetMapping("/products/secondTask")
    public List<SecondTask> getSecondTask(){
        return productRepository.getSecondTask();
    }
    @GetMapping("/products/thirdTask")
    public List<ThirdTask> getThirdTask(){
        return productRepository.getThirdTask();
    }
}
