package org.xhtmlrenderer.test;

import org.xhtmlrenderer.simple.Graphics2DRenderer;
import org.xhtmlrenderer.util.UPrint;

import java.io.File;
import java.util.Date;

public class HamletSpeedTest {

    public static void main(String[] args) throws Exception {
        long total = 0;
        for (int i = 0; i < 10; i++) {
            Date start = new Date();
            Graphics2DRenderer.renderToImage(
                    new File("demos/browser/xhtml/old/hamlet.xhtml").toURL().toExternalForm(),
                    700, 700);
            Date end = new Date();
            long diff = (end.getTime() - start.getTime());
            UPrint.p("ms = " + diff);
            total += diff;
        }
        long avg = total / 10;
        UPrint.p("average : " + avg);
    }
}
