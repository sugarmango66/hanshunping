package practiceInLecture.chap21.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTcp02Server {
    public static void main(String[] args) throws IOException {
          //字节流
//        ServerSocket serverSocket = new ServerSocket(9999);
//        System.out.println("listen port 9999, waiting");
//        Socket socket = serverSocket.accept();
//        System.out.println("server socket connected");
//
//        InputStream inputStream = socket.getInputStream();
//        byte[] buf = new byte[1024];
//        int readLen = 0;
//        while ((readLen = inputStream.read(buf)) != -1) {
//            System.out.println(new String(buf,0,readLen));
//        }
//
//
//        OutputStream outputStream = socket.getOutputStream();
//        outputStream.write("hello, client".getBytes());
//        socket.shutdownOutput();
//
//        inputStream.close();
//        outputStream.close();
//        socket.close();
//        serverSocket.close();

        //字符流
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("listen port 9999, waiting");
        Socket socket = serverSocket.accept();
        System.out.println("server socket connected");

        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);

        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello, client字符流");
        bufferedWriter.newLine();//indicate write end
        bufferedWriter.flush();//need update to put data in stream

        bufferedReader.close();
        bufferedWriter.close();
        socket.close();
        serverSocket.close();
    }
}
