package org.xhtmlrenderer.pdf.test;

import com.itextpdf.text.pdf.BaseFont;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * Created with e-contract.
 * User: pluto
 * Date: 3/11/15
 * Time: 7:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class PDFTest {

    public static void main(String[] args) throws Exception {
        String inputFile = "/Users/pluto/Project/test/XHTMLTest.xhtml";
        String url = new File(inputFile).toURI().toURL().toString();
        String outputFile = "/Users/pluto/Project/test/xhtmlCSS3.pdf";
        OutputStream os = new FileOutputStream(outputFile);
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocument(url);
        // 解决中文支持问题
        ITextFontResolver fontResolver = renderer.getFontResolver();
        fontResolver.addFont("/Library/Fonts/Arial Unicode.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        // 解决图片的相对路径问题
        //renderer.getSharedContext().setBaseURL("file:/D:/Work/Demo2do/Yoda/branch/Yoda%20-%20All/conf/template/");
        renderer.layout();
        renderer.createPDF(os);
        os.close();
    }
}
