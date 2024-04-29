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

import javax.xml.stream.events.Namespace;

public class HtmlToPdfConverter {

    public static void convert( String websiteUrl, String outputFileName) {

        // String websiteUrl = "https://www.google.com/webhp?hl=en&sa=X&ved=0ahUKEwial4Loud2FAxVE2TgGHaGQBM4QPAgJ";
        // String outputFileName = "google";

        try {
            
            // Document document = Jsoup.connect(websiteUrl).get();
            // String docString = document.toString();

            XHTMLPanel panel = new XHTMLPanel();
            panel.setDocument(new File("C:\\Users\\deban\\Documents\\sample.html"));
            System.out.println(panel.toString());
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocument(panel.getDocument(),null);
           

            String pathName ="E:\\generated_pdf";
            OutputStream outputStream = new FileOutputStream(pathName+"\\output1.pdf");
            renderer.layout();
            renderer.createPDF(outputStream);
            outputStream.close();
            System.out.println("PDF generated successfully.");








        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
