package com.example.shopping.Utils;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class GetPage{
    private final ModelMapper modelMapper;
    public <T,D> com.example.shopping.common.payload.Page<D> convertPage(Page<T> page,Class<D> dtoClass) {
        int totalPages = page.getTotalPages();
        List<T> contentList = page.toList();
        List<D> dtoResult = contentList.stream().map(model -> modelMapper.map(model,dtoClass)).collect(Collectors.toList());
        com.example.shopping.common.payload.Page<D> convertedPage = new com.example.shopping.common.payload.Page<>();
        convertedPage.setResult(dtoResult);
        convertedPage.setTotalPages(totalPages);
        convertedPage.setTotalItems((int) page.getTotalElements());
        convertedPage.setPageSize(page.getSize());
        convertedPage.setPageNumber(page.getNumber());
        return convertedPage;
    }


}
