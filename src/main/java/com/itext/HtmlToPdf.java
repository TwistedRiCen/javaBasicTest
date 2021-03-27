package com.itext;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.layout.font.FontProvider;

import java.io.*;


public class HtmlToPdf {

    private static final String resourcesDir = System.getProperty("user.dir") + "/src/main/resources";
    public void htmlToPdf() throws Exception {
        String path = resourcesDir + "/template/template.html";
        String destPath = resourcesDir + "/template/template.pdf";
        ConverterProperties converterProperties = new ConverterProperties();
        FontProvider dfp = new DefaultFontProvider();
        //dfp.addDirectory("C:/Windows/Fonts");
        dfp.addDirectory(resourcesDir + "/font");
        converterProperties.setFontProvider(dfp);
        try (InputStream in = new FileInputStream(new File(path)); OutputStream out = new FileOutputStream(new File(destPath))){
            HtmlConverter.convertToPdf(in, out, converterProperties);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception {
        new HtmlToPdf().htmlToPdf();
    }
}
