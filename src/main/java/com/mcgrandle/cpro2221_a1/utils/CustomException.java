package com.mcgrandle.cpro2221_a1.utils;

//creating a custom exception class to run a message during data validation
public class CustomException extends RuntimeException
{
    public CustomException(String message) { super(message); }
}
