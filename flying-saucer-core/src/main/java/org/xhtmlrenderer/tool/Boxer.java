// package PACKAGE;
package org.xhtmlrenderer.tool;

import org.xhtmlrenderer.test.DocumentDiffTest;

import java.io.File;

/**测试这个文件或目录是否存在
 *工具类
 */
public class Boxer {

    /**
     * @param filen 文件名
     */
    private void run(String filen) {
        try {
            File file = new File(filen);
            if (!file.exists() || file.isDirectory()) {
                throw new IllegalArgumentException(filen + " not a file, or is a directory. Give me a single file name.");
            }

            System.out.println(DocumentDiffTest.xhtmlToDiff(filen, 1024, 768));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String args[]) {
        try {
            if (args.length == 0) {

                throw new IllegalArgumentException("Give a file name");
            }
            new Boxer().run(args[0]);

        } catch (IllegalArgumentException e) {

            System.err.println(e.getMessage());
        }
    }
} // end class
