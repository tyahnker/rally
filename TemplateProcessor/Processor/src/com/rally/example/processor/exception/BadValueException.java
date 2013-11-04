package com.rally.example.processor.exception;

/**
 * Created with IntelliJ IDEA.
 * User: Tish
 * Date: 11/3/13
 */
public class BadValueException extends TemplateProcessorException
{
    public BadValueException(String message)
    {
        super(message);
    }
    public BadValueException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
