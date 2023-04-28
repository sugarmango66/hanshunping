package practiceInLecture.chap21.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketTcp02Client {
    public static void main(String[] args) throws IOException {
        //字节流
//        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
//        OutputStream outputStream = socket.getOutputStream();
//        outputStream.write("hello, server".getBytes());
//        socket.shutdownOutput();
//
//        InputStream inputStream = socket.getInputStream();
//        byte[] buf = new byte[1024];
//        int readLen = 0;
//        while((readLen=inputStream.read(buf)) !=-1) {
//            System.out.println(new String(buf,0,readLen));
//        }
//
//        outputStream.close();
//        inputStream.close();
//        socket.close();

        //字符流
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello, server字符流");
        bufferedWriter.newLine();
        bufferedWriter.flush();

        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);

        bufferedReader.close();
        bufferedWriter.close();
        socket.close();
    }
}
