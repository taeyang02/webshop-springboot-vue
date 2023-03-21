package com.example.shopping.Controller;

import com.example.shopping.Model.Product;
import com.example.shopping.Service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.xml.transform.Result;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@CrossOrigin
public class ProductController {
    private final IProductService productService;
    @GetMapping("")
    public ResponseEntity<Page<Product>> getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "12") int size
    ) {
        Page<Product> products = (Page<Product>) productService.findAll(PageRequest.of(page,size));
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{ids}")
    public List<Product> findAllById(@PathVariable List<Long> ids) {
        return productService.findAllById(ids);
    }

    @PostMapping("create")
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @GetMapping("/{id}")
    public Optional<Product> findOne(@PathVariable Long id) {
        Example<Product> example = Example.of(new Product());
        return productService.findOne(example);
    }
}
