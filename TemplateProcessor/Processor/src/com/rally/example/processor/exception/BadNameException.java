package com.rally.example.processor.exception;

/**
 * Created with IntelliJ IDEA.
 * User: Tish
 * Date: 11/3/13
 */
public class BadNameException extends TemplateProcessorException
{
    public  BadNameException(String message)
    {
        super(message);
    }

    public BadNameException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
