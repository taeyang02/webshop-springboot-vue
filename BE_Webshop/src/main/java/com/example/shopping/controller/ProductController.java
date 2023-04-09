package com.example.shopping.controller;

import com.example.shopping.common.payload.Result;
import com.example.shopping.model.DTO.ProductDto;
import com.example.shopping.model.Product;
import com.example.shopping.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@CrossOrigin
public class ProductController {
    private final IProductService productService;
    @GetMapping("")
    public Result<?> getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "12") int size
    ) {
        Page<Product> products = (Page<Product>) productService.findAll(PageRequest.of(page,size));
        return Result.result(HttpStatus.OK.value(),"Tìm Trang Thành Công",products);
    }

    @GetMapping("/{id}")
    public Result<?> findById(@PathVariable Long id) {
        return Result.result(HttpStatus.OK.value(),"Tìm Kiếm Thành Công",productService.findById(id));
    }

    @PostMapping("create")
    public Result<?> save(@RequestBody ProductDto dto) {
        return Result.result(HttpStatus.OK.value(),"Thêm Thành Công",productService.create(dto));
    }

}
