package com.rally.example.processor;

import com.rally.example.processor.exception.*;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: Tish
 * Date: 11/3/13
 */
public class TemplateProcessor implements ITemplateProcessor
{
    @Override
    public String replace(String template, Map<String, String> nameValuePairs) throws TemplateProcessorException
    {
        if (StringUtils.isBlank(template))
        {
            throw new TemplateProcessorException("Template is blank or empty: " + template);
        }

        if (nameValuePairs == null || nameValuePairs.size() <= 0)
        {
            throw new NameValuePairsEmptyOrNullException("The nameValuePairs given were null or empty: " + nameValuePairs);
        }


        List<String> escapedVariables = new ArrayList<String>();
        Pattern escapedPattern = Pattern.compile("\\$\\{\\$\\{[A-Za-z0-9_]*\\}\\}");
        //  get a matcher object
        Matcher escapedMatcher = escapedPattern.matcher(template);
        while (escapedMatcher.find())
        {
            String escapedVariable = escapedMatcher.group().replaceAll("\\$\\{\\$\\{", "");
            escapedVariable = escapedVariable.replaceAll("\\}\\}", "");
            escapedVariables.add(escapedVariable);
        }


        Set<String> keySet = nameValuePairs.keySet();
        Iterator keyIterator = keySet.iterator();
        while (keyIterator != null && keyIterator.hasNext())
        {
            String key = (String) keyIterator.next();
            if (StringUtils.isBlank(key))
            {
                throw new BadNameException("Key in the nameValuePair was null or empty: " + key);
            }

            String value = nameValuePairs.get(key);
            if (StringUtils.isBlank(value))
            {
                throw new BadValueException("Value in the nameValuePair was null or empty: " + value);
            }


            //Replace it in the given template using a regex.
            template = template.replaceAll("\\$\\{" + key + "\\}", value);

        }


        Pattern p = Pattern.compile("\\$\\{[A-Za-z0-9_]*\\}");
        //  get a matcher object
        Matcher m = p.matcher(template);

        while (m.find())
        {
            boolean found = false;
            String variable = m.group().replaceAll("\\$\\{", "");
            variable = variable.replaceAll("\\}", "");
            Iterator escapedIterator = escapedVariables.iterator();

            while (escapedIterator.hasNext())
            {
                if (nameValuePairs.get(escapedIterator.next()).equals(variable))
                {
                    found = true;
                    break;
                }
            }
            if (!found)
            {
                throw new VariableNotReplacedException("A variable has not been replaced : " + m.group());
            }
        }

        return template;
    }
}
