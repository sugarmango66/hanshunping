package practiceInLecture.chap21.fileUpload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
//注意设置结束标记
public class SocketTcpFileServer {
    public static void main(String[] args) throws IOException {
        //listen and establish connect
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("listen port 8888, waiting");
        Socket socket = serverSocket.accept();
        //receive byte[] from client via inputstream
        InputStream inputStream = socket.getInputStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        byte[] bytes = bufferedInputStream.readAllBytes();
        //store byte[] in disk via 字节输出流
        String dest = "/Users/suzanmagic/pic.png";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest));
        bos.write(bytes);
        //send feedback str to client via 字符输出流
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("img received");
        bufferedWriter.flush(); //内容刷新到数据通道
        socket.shutdownOutput();//indicate write end
        //close
        bufferedWriter.close();
        bos.close();
        bufferedInputStream.close();
        socket.close();
        serverSocket.close();
    }
}
