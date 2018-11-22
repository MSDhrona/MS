package com.dhrona.User.exception;

import com.dhrona.User.bean.ExceptionResponse;
import org.apache.tomcat.util.http.fileupload.util.Streams;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> invalidInput(MethodArgumentNotValidException e){
        BindingResult result = e.getBindingResult();
        List<String> errorMsg = new ArrayList<String>();
        result.getAllErrors().forEach(error->{
            errorMsg.add(error.getDefaultMessage());
        });
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode("400");
        response.setErrorMessage("Invalid Input");
        response.setErrors(errorMsg);
        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> invalidInput(Exception e){
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode("500");
        response.setErrorMessage("System Error");
        List<String> errorMsg = new ArrayList<String>();
        errorMsg.add(e.getMessage());
        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
