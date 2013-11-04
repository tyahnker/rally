package com.rally.example.processor.exception;

/**
 * Created with IntelliJ IDEA.
 * User: Tish
 * Date: 11/3/13
 */
public class VariableNotReplacedException extends TemplateProcessorException
{
    public VariableNotReplacedException(String message)
    {
        super(message);
    }

    public VariableNotReplacedException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
