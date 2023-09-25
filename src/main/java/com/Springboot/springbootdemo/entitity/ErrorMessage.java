package com.Springboot.springbootdemo.entitity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage
{
    private HttpStatus httpStatus;
    private String message;
}
