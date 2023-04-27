package practiceInLecture.chap19.objectIO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputStream_ {
    public static void main(String[] args) throws IOException {
        String dest = "/Users/suzanmagic/object.dat";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dest));
        oos.writeBoolean(false);
        oos.writeInt(33);
        oos.writeDouble(4.7);
        oos.writeChar('j');
        oos.writeUTF("great");
        oos.writeObject(new Cat("jituan", 5, new Owner("suzan")));
        oos.close();
        System.out.println("序列化完毕");
    }
}
