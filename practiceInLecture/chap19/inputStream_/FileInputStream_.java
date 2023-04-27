package practiceInLecture.chap19.inputStream_;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStream_ {
    public static void main(String[] args) {

    }
    @Test
    public void read01() throws IOException {
        String filePath = "/Users/suzanmagic/hello.txt";
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);
            /*
             * Reads a byte of data from this input stream. This method blocks if no input is yet available.
             * Returns:
             * the next byte of data, or -1 if the end of the file is reached.
             */
            while (true) {
                int read = fileInputStream.read();
                if (read == -1) break;
                System.out.print((char) read);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileInputStream.close();
        }
    }
    @Test
    public void read02() throws IOException {
        String filePath = "/Users/suzanmagic/hello.txt";
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);
            byte[] buf = new byte[4];
            /*
             * Reads up to b.length bytes of data from this input stream into an array of bytes.
             * This method blocks until some input is available.
             * Params:
             * b – the buffer into which the data is read.
             * Returns:
             * the total number of bytes read into the buffer,
             * or -1 if there is no more data because the end of the file has been reached.
             */
            while (true) {
                int readLen = fileInputStream.read(buf);
                if (readLen == -1) break;
                String data = new String(buf, 0, readLen);
                System.out.print(data);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileInputStream.close();
        }
    }

}
