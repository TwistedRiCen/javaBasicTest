package com.xhtmlrenderer;

import com.lowagie.text.pdf.BaseFont;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class HtmlToPdf {

    private static final String resourcesDir = System.getProperty("user.dir") + "/src/main/resources";

    public void htmlToPdf() throws Exception {
        String path = resourcesDir + "/template/template.html";
        String destPath = resourcesDir + "/template/template.pdf";
        ITextRenderer renderer = new ITextRenderer();
        OutputStream os = new FileOutputStream(destPath);
        renderer.setDocument(new File(path));
        ITextFontResolver resolver = renderer.getFontResolver();
        //添加字体，解决中文不显示的问题
        resolver.addFont(resourcesDir + "/font/simsun.ttc", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        renderer.layout();
        renderer.createPDF(os);
        os.close();
    }

    public static void main(String[] args) throws Exception {
        new HtmlToPdf().htmlToPdf();
    }

}
