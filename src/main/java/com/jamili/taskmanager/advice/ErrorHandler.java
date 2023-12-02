package com.jamili.taskmanager.advice;

import com.jamili.taskmanager.advice.exceptions.NotFoundException;
import com.jamili.taskmanager.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public String IncompleteConstructorExceptionHandler(MethodArgumentNotValidException ex) {
        return "Field: " + ex.getBindingResult().getFieldError().getField() +
                " - Error description: " + ex.getBindingResult().getFieldError().getDefaultMessage();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorMessage> NotFoundException(Exception exception) {
        return new ResponseEntity<>(new ErrorMessage("Task not found"), HttpStatus.NOT_FOUND);
    }

}
