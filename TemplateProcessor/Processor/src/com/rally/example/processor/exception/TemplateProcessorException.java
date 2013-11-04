package com.rally.example.processor.exception;

/**
 * Created with IntelliJ IDEA.
 * User: Tish
 * Date: 11/3/13
 */
public class TemplateProcessorException extends Exception
{

    public TemplateProcessorException(String message)
    {
        super(message);
    }
    public TemplateProcessorException(String message, Throwable cause)
    {
        super(message, cause);
    }

}
