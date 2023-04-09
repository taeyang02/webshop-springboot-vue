package com.example.shopping.exception;

import com.example.shopping.common.payload.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@Slf4j
@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(DuplicateEntityException.class)
    public Result<?> duplicateEntityException(DuplicateEntityException ex, WebRequest request) {
        log.error("Something went wrong: "+ex.getMessage());
        return Result.error(HttpStatus.CONFLICT.value(), ex.getMessage());
    }

    @ExceptionHandler(EntityAlreadyExistException.class)
    public Result<?> entityAlreadyExistException(EntityAlreadyExistException ex, WebRequest request) {
        log.error("Something went wrong: "+ex.getMessage());
        return Result.error(HttpStatus.CONFLICT.value(), ex.getMessage());
    }

    @ExceptionHandler(EntityIsEmptyException.class)
    public Result<?> entityIsEmptyException(EntityIsEmptyException ex, WebRequest request) {
        log.error("Something went wrong: "+ex.getMessage());
        return Result.error(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public Result<?> entityNotFoundException(EntityNotFoundException ex, WebRequest request) {
        log.error("Something went wrong: "+ex.getMessage());
        return Result.result(HttpStatus.NOT_FOUND.value(), ex.getMessage(), null);
    }

    @ExceptionHandler(NotEnoughStockException.class)
    public Result<?> notEnoughStockException(NotEnoughStockException ex, WebRequest request) {
        log.error("Something went wrong: "+ex.getMessage());
        return Result.error(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }

    @ExceptionHandler(OrderUpdateException.class)
    public Result<?> orderUpdateException(OrderUpdateException ex, WebRequest request) {
        log.error("Something went wrong: "+ex.getMessage());
        return Result.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
    }

    @ExceptionHandler(QuartzException.class)
    public Result<?> quartzException(QuartzException ex, WebRequest request) {
        log.error("Something went wrong: "+ex.getMessage());
        return Result.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
    }
    @ExceptionHandler(PaymentFail.class)
    public Result<?> paymentFail(PaymentFail ex, WebRequest request) {
        log.error("Something went wrong: "+ex.getMessage());
        return Result.error(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }
    @ExceptionHandler(EntityInvalid.class)
    public Result<?> entityInvalid(EntityInvalid ex, WebRequest request) {
        log.error("Something went wrong: "+ex.getMessage());
        return Result.error(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result<?> globalExceptionHandler(Exception ex, WebRequest request) {
        log.error("Something went wrong: "+ex.getMessage());
        return Result.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Something went wrong");
    }

}
