package com.rally.example.processor.exception;

/**
 * Created with IntelliJ IDEA.
 * User: Tish
 * Date: 11/3/13
 */
public class TemplateException extends TemplateProcessorException
{
    public TemplateException(String message)
    {
        super (message);
    }
    public TemplateException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
