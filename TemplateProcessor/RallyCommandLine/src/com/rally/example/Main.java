package com.rally.example;

import com.rally.example.processor.ITemplateProcessor;
import com.rally.example.processor.TemplateProcessor;
import com.rally.example.processor.exception.TemplateProcessorException;

import java.util.HashMap;
import java.util.Map;

public class Main
{

    public static void main(String[] args)
    {

        System.out.println("*****************************************************");
        System.out.println("*************** Good Run ****************************");
        System.out.println("*****************************************************");

        Map<String, String> templateNameValuePairs = new HashMap<String, String>();

        templateNameValuePairs.put("First", "John");
        templateNameValuePairs.put("Last", "Reuning");
        templateNameValuePairs.put("Company", "Rally");
        templateNameValuePairs.put("From_First", "Tish");
        templateNameValuePairs.put("From_Last", "Yahnker");

        String templateStr = "Dear ${First} ${Last},\n" +
                "\n" +
                "I look forward to working for your company, ${Company}. \n" +
                "I've heard that ${${Company}} is a great place to work.\n" +
                "\n" +
                "Thanks,\n" +
                "\n" +
                "${From_First} ${From_Last}\n\n";
        ITemplateProcessor templateProcessor = new TemplateProcessor();
        try
        {
            String goodRun = templateProcessor.replace(templateStr, templateNameValuePairs);

            System.out.println("****TEMPLATE = ");
            System.out.print(templateStr);

            System.out.println("*****AFTER REPLACEMENT");
            System.out.print(goodRun);
        }
        catch (TemplateProcessorException e)
        {
            System.out.println("TemplateProcessorException caught: " + e);
            e.printStackTrace(System.out);
        }

        System.out.println("*****************************************************");
        System.out.println("*************** Null Template ***********************");
        System.out.println("*****************************************************");

        try
        {
            String templateStrNull = null;
            String nullRun = templateProcessor.replace(templateStrNull, templateNameValuePairs);
        }
        catch (TemplateProcessorException e)
        {
            System.out.println("TemplateProcessorException caught: " + e);
            e.printStackTrace(System.out);
        }

        System.out.println("*****************************************************");
        System.out.println("*************** Null NameValuePai********************");
        System.out.println("*****************************************************");

        try
        {
            String templateStrNull = null;
            String nullRun = templateProcessor.replace(templateStr, null);
        }
        catch (TemplateProcessorException e)
        {
            System.out.println("TemplateProcessorException caught: " + e);
            e.printStackTrace(System.out);
        }


        templateNameValuePairs.put("Bad", "");

        System.out.println("*****************************************************");
        System.out.println("*************** Bad Value **************************");
        System.out.println("*****************************************************");

        try
        {
            String badValue = templateProcessor.replace(templateStr, templateNameValuePairs);
        }
        catch (TemplateProcessorException e)
        {
            System.out.println("TemplateProcessorException caught: " + e);
            e.printStackTrace(System.out);

        }

        System.out.println("*****************************************************");
        System.out.println("*************** Bad Name ****************************");
        System.out.println("*****************************************************");

        templateNameValuePairs.remove("Bad");
        templateNameValuePairs.put("", "Value");

        try
        {
            String badName = templateProcessor.replace(templateStr, templateNameValuePairs);
        }
        catch (TemplateProcessorException e)
        {
            System.out.println("TemplateProcessorException caught: " + e);
            e.printStackTrace(System.out);

        }


        System.out.println("*****************************************************");
        System.out.println("*************** Missing Replacement *****************");
        System.out.println("*****************************************************");

        templateNameValuePairs.remove("");

        try
        {
            String templateStr2 = "Dear ${First} ${Last},\n" +
                    "\n" +
                    "I look forward to working for your company, ${Company}. \n" +
                    "I've heard that ${${Company}} is a great place to work.\n" +
                    "This line contains a variable ${missing} that will not be replaced.\n" +
                    "\n" +
                    "Thanks,\n" +
                    "\n" +
                    "${From_First} ${From_Last}\n\n";
            System.out.println("****TEMPLATE = ");
            System.out.print(templateStr2);
            String missingReplacement = templateProcessor.replace(templateStr2, templateNameValuePairs);
        }
        catch (TemplateProcessorException e)
        {
            System.out.println("TemplateProcessorException caught: " + e);
            e.printStackTrace(System.out);
        }


    }
}
