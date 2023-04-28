package practiceInLecture.chap21;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddress_ {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);
        InetAddress host = InetAddress.getByName("www.baidu.com");
        System.out.println(host);
        String hostName = host.getHostName();
        String hostAddress = host.getHostAddress();
        System.out.println(hostName+" "+hostAddress);
    }
}
