//package com.lzapi.controller.common.exception;
//
//import com.lzapi.common.CodeMsg;
//import com.lzapi.common.Result;
//import org.apache.shiro.authz.UnauthenticatedException;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.converter.HttpMessageNotReadableException;
//import org.springframework.validation.BindException;
//import org.springframework.validation.ObjectError;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.List;
//
///**
// * Created by lc on 2018/6/9.
// */
//@ControllerAdvice
//@ResponseBody
//public class GlobalExceptionHandler {
//
//    static {
//        System.out.println("ControllerAdvice记载");
//    }
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(HttpMessageNotReadableException.class)
//    public Result<String> messageNotReadable(HttpMessageNotReadableException exception, HttpServletResponse response){
//        return Result.Error(CodeMsg.Err_Param);
//    }
//
//    @ExceptionHandler(value=Exception.class)
//    public Result<String> exceptionHandler(HttpServletRequest request, Exception e){
//        e.printStackTrace();
//        if(e instanceof BindException) {
//            BindException ex = (BindException)e;
//            List<ObjectError> errors = ex.getAllErrors();
//            ObjectError error = errors.get(0);
//            String msg = error.getDefaultMessage();
//            return Result.Error(CodeMsg.Err_Param);
//        }
//        return Result.Error(CodeMsg.Err_Param);
//    }
//}
