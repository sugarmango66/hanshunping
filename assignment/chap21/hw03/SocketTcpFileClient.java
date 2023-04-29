package assignment.chap21.hw03;
/*
client send a music name, server give back the file(if not exti, give default)
client save file to local.
 */
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class SocketTcpFileClient {
    public static void main(String[] args) throws Exception {
        //establish connect
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        //get file name str
        String filename = "小幸运 (钢琴版) - 昼夜";
        //deliver str to server via outputstream
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        bw.write(filename);
        bw.flush();
        socket.shutdownOutput();//indicate write end
        //receive feedback byte[] from server via 字符输入流
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = StreamUtils.streamToByteArray(inputStream);
        System.out.println("server sent a file ");
        //store byte[] local via 字节输出流
        String dest = "/Users/suzanmagic/downloads/stored.mp3";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest));
        bos.write(bytes);

        //close resource
        bos.close();
        bw.close();
        socket.close();

    }
}
