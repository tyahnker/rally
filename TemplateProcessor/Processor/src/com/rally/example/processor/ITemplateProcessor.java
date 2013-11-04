package com.rally.example.processor;

import com.rally.example.processor.exception.TemplateProcessorException;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Tish
 * Date: 11/3/13
 */
public interface ITemplateProcessor
{
    String replace(String template, Map<String, String> nameValuePairs) throws TemplateProcessorException;
}
