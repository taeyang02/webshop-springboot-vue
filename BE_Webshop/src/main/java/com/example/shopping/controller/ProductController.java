package com.example.shopping.controller;

import com.example.shopping.common.payload.Result;
import com.example.shopping.domain.DTO.ProductDTO;
import com.example.shopping.domain.model.Product;
import com.example.shopping.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@CrossOrigin
public class ProductController {
    private final IProductService productService;
    private final CacheManager cacheManager;
    @GetMapping(value = "")
    public Result<?> getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "12") int size
    ) {
        return Result.result(HttpStatus.OK.value(),"Tìm Trang Thành Công",productService.fillAll(PageRequest.of(page,size)));
    }

    @Cacheable(value = "product", key = "#id")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<?> findById(@PathVariable Long id) {
        ProductDTO product = productService.findById(id);
        if (product == null) {
            throw new RuntimeException("Product not found with id: " + id);
        }
        return Result.result(HttpStatus.OK.value(),"Tìm Kiếm Thành Công",product);

    }

    @PostMapping("create")
    public Result<?> save(@RequestBody ProductDTO dto) {
        return Result.result(HttpStatus.OK.value(),"Thêm Thành Công",productService.create(dto));
    }

    @GetMapping("/cache")
    public List<Object> getAllCachedData() {
        Cache cache = cacheManager.getCache("product");
        ConcurrentMap<Object, Object> nativeCache = (ConcurrentMap<Object, Object>) cache.getNativeCache();
        return new ArrayList<>(nativeCache.values());
    }

}
