package practiceInLecture.chap19.fileCopy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) throws IOException {
        String srcFile = "/Users/suzanmagic/hello.txt";
        String destFile = "/Users/suzanmagic/Downloads/hi.txt";
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            fileInputStream = new FileInputStream(srcFile);
            fileOutputStream = new FileOutputStream(destFile);
            byte[] buf = new byte[8];
            int readLen = 0;
            while ((readLen = fileInputStream.read(buf)) != -1) {
                //read a buf then deliver write instantly
                String data = new String(buf, 0, readLen);
                fileOutputStream.write(data.getBytes());
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileInputStream.close();
            fileOutputStream.close();
        }


    }
}
