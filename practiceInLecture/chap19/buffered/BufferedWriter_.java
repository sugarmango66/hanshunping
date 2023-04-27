package practiceInLecture.chap19.buffered;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriter_ {
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Users/suzanmagic/hello.txt", true));
        bufferedWriter.newLine();//换行
        bufferedWriter.write("姗姗来迟");
        bufferedWriter.close();//只有close 后才能写入文件
    }
}
