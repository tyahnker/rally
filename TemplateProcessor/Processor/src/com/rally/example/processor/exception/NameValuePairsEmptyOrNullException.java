package com.rally.example.processor.exception;

/**
 * Created with IntelliJ IDEA.
 * User: Tish
 * Date: 11/3/13
 */
public class NameValuePairsEmptyOrNullException extends TemplateProcessorException
{
    public NameValuePairsEmptyOrNullException(String message)
    {
        super (message);
    }
    public NameValuePairsEmptyOrNullException(String message, Throwable cause)
    {
        super(message, cause);
    }

}
