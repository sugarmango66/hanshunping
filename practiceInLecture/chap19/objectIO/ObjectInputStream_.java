package practiceInLecture.chap19.objectIO;

import java.io.*;

public class ObjectInputStream_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String src = "/Users/suzanmagic/object.dat";
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(src));
        //read in order with how write into dat file
        System.out.println(ois.readBoolean());
        System.out.println(ois.readInt());
        System.out.println(ois.readDouble());
        System.out.println(ois.readChar());
        System.out.println(ois.readUTF());
        Cat cat = (Cat)ois.readObject();
        System.out.println(cat);
    }
}
