package practiceInLecture.chap19.ouputStream_;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStream_ {
    public static void main(String[] args) {

    }

    @Test
    public void FileOutputStream01() throws IOException {
        String filePath = "/Users/suzanmagic/hello.txt";
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(filePath, true);
            fileOutputStream.write('P');

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileOutputStream.close();
        }

    }

    @Test
    public void FileOutputStream02() throws IOException {
        String filePath = "/Users/suzanmagic/hello.txt";
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(filePath, true);
            String data = "great";
            fileOutputStream.write(data.getBytes());//String to byte[]

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileOutputStream.close();
        }

    }
}
