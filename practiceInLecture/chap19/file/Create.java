package practiceInLecture.chap19.file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class Create {
    public static void main(String[] args) {

    }
    @Test
    public void create1() {
        String filePath = "/Users/suzanmagic/new1.txt";
        File file = new File(filePath);
        try {
            file.createNewFile();
            System.out.println("success");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void create2() {
        File parentFile = new File("/Users/suzanmagic/");
        String fileName = "new2.txt";
        File file = new File(parentFile, fileName);
        try {
            file.createNewFile();
            System.out.println("success2");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void create3() {
        String parentPath = "/Users/suzanmagic/";
        String fileName = "new3.txt";
        File file = new File(parentPath, fileName);
        try {
            file.createNewFile();
            System.out.println("success3");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

