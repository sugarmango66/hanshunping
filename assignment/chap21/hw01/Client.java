package assignment.chap21.hw01;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        Scanner scanner = new Scanner(System.in);
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        InputStream inputStream = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));


        System.out.println("what is your question: ");
        String question = scanner.nextLine();

        bw.write(question);
        bw.flush();
        socket.shutdownOutput();

        String answer = br.readLine();
        System.out.println("server msg: " + answer);


        br.close();
        bw.close();
        socket.close();
    }
}
