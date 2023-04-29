package assignment.chap21.hw03;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//注意设置结束标记
public class SocketTcpFileServer {
    public static void main(String[] args) throws Exception {
        //listen and establish connect
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("listen port 8888, waiting");
        Socket socket = serverSocket.accept();
        //receive str from client via inputstream
        InputStream inputStream = socket.getInputStream();
        String filename = StreamUtils.streamToString(inputStream).trim();//!!!need trim whitespace
        System.out.println(filename);
        //find file match name, if not exist give default
//        String filepath = "/Users/suzanmagic/music/" + filename + ".mp3";
        String filepath = String.format("/Users/suzanmagic/music/%s.mp3", filename);
        System.out.println(filepath);
        File file = new File(filepath);
        if (!file.exists()) {
            file = new File("/Users/suzanmagic/music/致你 - yihuik苡慧.mp3");
        }
        //turn file to byte[]
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bytes = StreamUtils.streamToByteArray(fileInputStream);
        //send byte[] to client via 字节输出流
        OutputStream outputStream = socket.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(outputStream);
        bos.write(bytes);
        bos.flush(); //内容刷新到数据通道
        socket.shutdownOutput();//indicate write end
        //close
        bos.close();
        bos.close();
        socket.close();
        serverSocket.close();
    }
}
