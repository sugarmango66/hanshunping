package practiceInLecture.chap21.fileUpload;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class SocketTcpFileClient {
    public static void main(String[] args) throws IOException {
        //establish connect
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        //get byte[] of file via 字节输入流
        String filepath = "/Users/suzanmagic/pictures/Mood-Check-In.png";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filepath));
        byte[] bytes = bis.readAllBytes();
        //deliver byte[] to server via outputstream
        OutputStream outputStream = socket.getOutputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        bufferedOutputStream.write(bytes);
        socket.shutdownOutput();//indicate write end
        //receive feedback str from server via 字符输入流
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String feedback = bufferedReader.readLine();
        System.out.println("server msg: " + feedback);
        //close resource
        bufferedReader.close();
        bufferedOutputStream.close();
        bis.close();
        socket.close();

    }
}
