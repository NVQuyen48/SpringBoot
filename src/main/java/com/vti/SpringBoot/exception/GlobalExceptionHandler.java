package com.vti.SpringBoot.exception;

import com.vti.SpringBoot.dto.request.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(value = Exception.class)

    //    public ResponseEntity<ApiResponse> handlingRuntimeException(RuntimeException ex) {
//        ApiResponse apiResponse = new ApiResponse();
//
//        apiResponse.setCode(ErrorCode.UNCATEGORIZED.getCode());
//        apiResponse.setMessage(ErrorCode.UNCATEGORIZED.getMessage());
//
//        return ResponseEntity.badRequest().body(apiResponse);
//    }
//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<ApiResponse> handlingRuntimeException(
//            RuntimeException ex
//    ) {
//        ApiResponse res = new ApiResponse();
//        res.setMessage(ex.getMessage());
//
//        return ResponseEntity.badRequest().body(res);
//    }

    @ExceptionHandler(value = AppException.class)
    ResponseEntity<ApiResponse> handleException(AppException ex) {
        ErrorCode errorCode = ex.getErrorCode();

        ApiResponse apiResponse = new ApiResponse();

        apiResponse.setCode(errorCode.getCode());
        apiResponse.setMessage(errorCode.getMessage());

        return ResponseEntity.badRequest().body(apiResponse);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<ApiResponse> handleException(MethodArgumentNotValidException ex) {
        String enumKey = ex.getFieldError().getDefaultMessage();

        ErrorCode errorCode = ErrorCode.valueOf(enumKey);
        ApiResponse apiResponse = new ApiResponse();

        apiResponse.setCode(errorCode.getCode());
        apiResponse.setMessage(errorCode.getMessage());
        return ResponseEntity.badRequest().body(apiResponse);
    }
}
