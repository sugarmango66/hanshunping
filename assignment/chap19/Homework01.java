package assignment.chap19;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Homework01 {

    public static void main(String[] args) throws IOException {
        //判断/Users/suzanmagic/下是否有mytemp 如无则创建
        String folder = "/Users/suzanmagic/mytemp";
        File file = new File(folder);
        if (!file.exists()) {
            if(file.mkdirs()) {
                System.out.println(folder+" created ok");
            }else {
                System.out.println(folder+" created fail");
            }
        }

        //判断mytemp下是否有hello.txt
        //如无则创建 如有提醒不要重复创建
        String filename = "hello.txt";
        File file1 = new File(folder, filename);
        if (file1.exists()) {
            System.out.println(filename+" already exist. no need to create again");
        } else {
            if (file1.createNewFile()){
                System.out.println(filename+" created ok");
            }else{
                System.out.println(filename+" created fail");
            }
        }

        //写入内容
//        String dest = folder+"/"+filename;
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file1, true));
        bufferedWriter.write("hello, world");
        bufferedWriter.close();
    }

}
