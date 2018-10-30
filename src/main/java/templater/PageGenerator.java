package templater;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.Map;

public class PageGenerator
{
    private static final String PAGES_DIR="pages";

    private static PageGenerator pageGenerator;
    private final Configuration cfg;

    private PageGenerator()
    {
        cfg = new Configuration();
    }

    public String getPage(String filename, Map<String,Object> data)
    {
        Writer stream = new StringWriter();
        try
        {
            Template template = cfg.getTemplate(PAGES_DIR + File.separator + filename);
            template.process(data,stream);
        }
        catch (IOException | TemplateException e)
        {
            e.printStackTrace();
        }
        return stream.toString();
    }

    public static PageGenerator instance()
    {
        if(pageGenerator == null)
            pageGenerator = new PageGenerator();
        return pageGenerator;
    }
}
