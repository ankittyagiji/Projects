package com.levent.consultantapi.exceptioncontroller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.levent.consultantapi.exception.CustomException;
import com.levent.consultantapi.response.ErrorResponse;

@ControllerAdvice
public class ErrorhandlingController {
          
                @ExceptionHandler(Exception.class)
                public ResponseEntity<ErrorResponse> generalException(Exception e)throws Exception{
                                ErrorResponse er = new ErrorResponse();
                                er.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
                                //er.setErrorMessage(e.getMessage());
                                System.out.println("Error is --> "+e);
                                return new ResponseEntity<ErrorResponse>(er, HttpStatus.INTERNAL_SERVER_ERROR);
                }

                @ExceptionHandler(CustomException.class)
                @ResponseStatus(HttpStatus.BAD_REQUEST)
                @ResponseBody
                public ResponseEntity<ErrorResponse> specialException(CustomException e,HttpServletRequest httpServletRequest)throws Exception{
                                ErrorResponse er = new ErrorResponse();
                                er.setErrorMessage(e.getMessage());
                                er.setErrorCode(10);
                                er.setStatus(HttpStatus.BAD_REQUEST.value());
                                //er.setErrorMessage(e.getMessage());
                                System.out.println("Error is --> "+e);
                                return new ResponseEntity<ErrorResponse>(er, HttpStatus.BAD_REQUEST);
                }
}