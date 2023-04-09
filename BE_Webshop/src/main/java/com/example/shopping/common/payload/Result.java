package com.example.shopping.common.payload;

import com.example.shopping.Utils.CommonUtils;
import com.example.shopping.Utils.JsonUtils;
import com.example.shopping.common.validate.CheckError;
import com.example.shopping.exception.GlobalException;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@SuppressWarnings("rawtypes")
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private int code;
    private String message;
    private String redirect;
    private T data;
    private String mtCount;
    private String msgLength;
    private String account;
    private String errorCode;
    private String errorMessage;
    private String referentId;

    public static Result<Object> success(Object data) {
        return Result.result(ResultCode.SUCCESS, "success", data);
    }

    public static Result<Object> success() {
        return Result.success(null);
    }

    public static Result<Object> success(String templateMessage, Object data) {
        return Result.result(ResultCode.SUCCESS, GlobalException.format(templateMessage), data);
    }

    public static Result<Object> successWithMessage(String templateMessage) {
        return success(templateMessage, null);
    }

    public static Result<Object> error(Integer code, String templateMessage) {
        return Result.result(code, GlobalException.format(templateMessage), null);
    }

    public static Result<Object> error(Integer code, String templateMessage, Object data) {
        return Result.result(code, GlobalException.format(templateMessage), data);
    }

    public static Result<Object> error(Integer code, String templateMessage, String... args) {
        return Result.result(code, GlobalException.format(templateMessage, args), null);
    }

    public static Result result(Object data, String msgLength, String mtCount, String account, String errorCode, String errorMessage, String referentId) {
        Result result = new Result();
        return result.setMsgLength(msgLength)
                .setMsgLength(msgLength)
                .setMtCount(mtCount)
                .setAccount(account)
                .setErrorCode(errorCode)
                .setErrorMessage(errorMessage)
                .setReferentId(referentId)
                .setData(data);
    }

    public Result redirect(String redirect) {
        this.redirect = redirect;
        return this;
    }

    @SuppressWarnings("unchecked")
    public static Result<Object> result(Integer code, String message, Object data) {
        Result<Object> result = new Result<>();
        return result.setCode(code)
                .setMessage(message)
                .setData(data);
    }

    public static Result<Object> check(CheckError checkError, String success) {
        if (checkError.isPass()) {
            Result<Object> results = Result.success();
            if (CommonUtils.notEmpty(success))
                results.setMessage(GlobalException.format(success));
            return results;
        } else {
            return Result.error(ResultCode.PRECONDITION_FAILED, GlobalException.format(checkError.getFirstErrorMessage()));
        }
    }

    public static Result<Object> check(BindingResult bindingResult) {
        return Result.error(ResultCode.VERIFICATION_FAILED, bindingResult.getFieldError().getDefaultMessage());
    }

    public static Result<Object> check(CheckError checkError) {
        return check(checkError, null);
    }

    public ResponseEntity<Result<T>> asOkResponseEntity() {
        return ResponseEntity
                .ok()
                .body(this);
    }

    public String toJson() {
        return JsonUtils.toJson(this);
    }
}
