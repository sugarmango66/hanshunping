package assignment.chap19;

import java.io.*;

public class Homework02 {
    public static void main(String[] args) throws IOException {
        String src = "/Users/suzanmagic/mytemp/hello.txt";
//        BufferedReader bufferedReader = new BufferedReader(new FileReader(src));
        //如果file encode is not utf8, change responding para
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(src), "utf8"));
        String line = null;
        int i = 1;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(i + line);
            i++;
        }
        bufferedReader.close();

    }
}
