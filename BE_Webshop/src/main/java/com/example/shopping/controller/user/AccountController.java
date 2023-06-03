package com.example.shopping.controller.user;

import com.example.shopping.common.payload.Result;
import com.example.shopping.domain.dto.AccountDTO;
import com.example.shopping.service.IAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
@CrossOrigin
public class AccountController {
    private final IAccountService accountService;

    @GetMapping(value = "")
    public Result<?> getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return Result.result(HttpStatus.OK.value(),"Tìm Trang Thành Công",accountService.fillAll(PageRequest.of(page,size)));
    }

    @PostMapping(value = "/create")
    public Result<?> createAccount(@RequestBody AccountDTO dto) {
        return Result.result(HttpStatus.OK.value(),"Tạo Tài Khoản Thành Công", accountService.create(dto));
    }

    @PutMapping(value = "/update")
    public Result<?> updateAccount(@RequestBody AccountDTO dto) {
        return Result.result(HttpStatus.OK.value(),"Cập Nhật Tài Khoản Thành Công", accountService.update(dto));
    }

    @DeleteMapping(value = "/delete")
    public Result<?> deleteAccount(@RequestBody AccountDTO dto) {
        return Result.result(HttpStatus.OK.value(),"Xóa Tài Khoản Thành Công", accountService.delete(dto));
    }

    @GetMapping(value = "/find-by-id/{id}")
    public Result<?> getAccountById(@PathVariable("id") Long id) {
        return Result.result(HttpStatus.OK.value(),"Tìm Tài Khoản Thành Công", accountService.findById(id));
    }



}
