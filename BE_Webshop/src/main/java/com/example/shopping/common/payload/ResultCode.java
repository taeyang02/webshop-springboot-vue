package com.example.shopping.common.payload;

public interface ResultCode {
    int SUCCESS = 200;
    
    int FILE_ALREADY_EXISTS = 220;
    
    int BAD_REQUEST = 400;
    
    int UNAUTHORIZED = 401;
    
    int NOT_LOGIN = 402;
    
    int NOT_FOUND = 404;
    
    int NOT_ACCEPTABLE = 406;
    
    int CONFLICT = 409;
    
    int PRECONDITION_FAILED = 412;
    
    int VERIFICATION_FAILED = 499;
    
    int INTERNAL_SERVER_ERROR = 500;
    
    int NOT_IMPLEMENTED = 501;
}