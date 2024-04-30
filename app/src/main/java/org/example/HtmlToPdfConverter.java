package org.example;

import org.checkerframework.checker.regex.qual.Regex;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.xhtmlrenderer.extend.NamespaceHandler;
// import org.jsoup.nodes.Element;
// import org.jsoup.select.Elements;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xhtmlrenderer.simple.XHTMLPanel;

import com.itextpdf.text.pdf.codec.Base64.InputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URL;
import org.jsoup.select.Elements;
// import javax.lang.model.util.Elements;
import javax.swing.text.html.parser.Element;
import javax.xml.stream.events.Namespace;

public class HtmlToPdfConverter {

    public static void convert( String websiteUrl, String outputFileName) {

        // String websiteUrl = "https://www.google.com/webhp?hl=en&sa=X&ved=0ahUKEwial4Loud2FAxVE2TgGHaGQBM4QPAgJ";
        // String outputFileName = "google";

        try {
            
            Document document = Jsoup.connect(websiteUrl).get();
            String docString = document.toString();
            Document parsedDocument = Jsoup.parse(docString);
            // String html = parsedDocument.html();
            // String css = document.cssSelector();
            
            // System.out.println(html);
            int i = 0;
           Elements styleElements = parsedDocument.select("style");
           for (org.jsoup.nodes.Element element : styleElements) {
               element.remove();
               
            }
            System.out.println(i);
            int j = 0;
            Elements scriptElements = parsedDocument.select("script");
            for (org.jsoup.nodes.Element element : scriptElements) {
                element.remove();;
                
            }
            System.out.println(j);

            System.out.println(parsedDocument);
            System.out.println(parsedDocument.documentType());
            // XHTMLPanel panel = new XHTMLPanel();
            // System.out.println(panel.toString());
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(parsedDocument.html());
           

            String pathName ="E:\\generated_pdf";
            OutputStream outputStream = new FileOutputStream(pathName+"\\"+outputFileName+".pdf");
            renderer.layout();
            renderer.createPDF(outputStream);
            outputStream.close();
            
            System.out.println("PDF generated successfully.");




        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
