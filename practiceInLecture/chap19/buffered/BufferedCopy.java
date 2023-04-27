package practiceInLecture.chap19.buffered;

import java.io.*;
//1. BufferedReader 和 BufferedWriter 是按字符操作
//2. 不要去操作 二进制文件[声音，视频，doc, pdf ], 可能造成文件损坏
public class BufferedCopy {
    public static void main(String[] args) throws IOException {
        String srcFile = "/Users/suzanmagic/hello.txt";
        String destFile = "/Users/suzanmagic/Downloads/hello2.txt";

        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(srcFile));
            bufferedWriter = new BufferedWriter(new FileWriter(destFile));

            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
        }

    }
}
