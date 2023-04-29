package assignment.chap21.hw01;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {//todo 目前问一次就退出 how可以一直问（聊天）
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("listening 8888");
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String question = br.readLine();
        System.out.println("client msg: " + question);
        String answer = "";
        switch (question) {
            case "name":
                answer = "suzan";
                break;
            case "hobby":
                answer = "code java";
                break;
            default:
                answer = "what do you say?";
        }
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        bw.write(answer);
        bw.flush();
        socket.shutdownOutput();

        bw.close();
        br.close();
        socket.close();
        serverSocket.close();
    }
}
