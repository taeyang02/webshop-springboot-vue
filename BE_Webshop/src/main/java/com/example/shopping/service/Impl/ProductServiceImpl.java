package com.example.shopping.service.Impl;

import com.example.shopping.Utils.GetPage;
import com.example.shopping.domain.DTO.ProductDTO;
import com.example.shopping.domain.Mapper.IProductMapper;
import com.example.shopping.domain.model.Product;
import com.example.shopping.reponsitory.ProductRepository;
import com.example.shopping.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {
    private final ProductRepository productRepository;
    private final IProductMapper mapper;
    private final GetPage getPage;

    private com.example.shopping.common.payload.Page<?> getPage(Page<Product> result) {
        int totalPages = result.getTotalPages();
        List<Product> productList = result.toList();
        List<ProductDTO> DTOList = mapper.toDtoList(productList);
        com.example.shopping.common.payload.Page pageProduct = new com.example.shopping.common.payload.Page();
        pageProduct.setResult(DTOList);
        pageProduct.setTotalPages(totalPages);
        pageProduct.setTotalItems((int) result.getTotalElements());
        pageProduct.setPageSize(result.getSize());
        pageProduct.setPageNumber(result.getNumber());
        return pageProduct;
    }

    @Override
    public Page<?> findAll(Pageable pageable) {
    Page<Product> result = productRepository.findAll(pageable);
        return result;
    }

    @Override
    public ProductDTO create(ProductDTO dto) {
        return mapper.toDto(productRepository.save(mapper.toEntity(dto)));
    }

    @Override
    public ProductDTO update(ProductDTO dto) {
        dto.setStatus(false);
        return mapper.toDto(productRepository.save(mapper.toEntity(dto)));
    }

    @Override
    public ProductDTO delete(ProductDTO dto) {
        dto.setStatus(false);
        return mapper.toDto(productRepository.save(mapper.toEntity(dto)));
    }

    @Override
    public com.example.shopping.common.payload.Page<?> fillAll(Pageable pageable) {
        Page<Product> result = productRepository.findAll(pageable);
        return getPage.convertPage(result, ProductDTO.class);
    }

    @Override
    public ProductDTO findById(Long aLong) {
        return mapper.toDto(productRepository.findById(aLong).orElse(null));
    }
}
