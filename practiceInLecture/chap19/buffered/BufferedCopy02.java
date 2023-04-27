package practiceInLecture.chap19.buffered;

import java.io.*;

public class BufferedCopy02 {
    public static void main(String[] args) throws IOException {
        String srcFile = "/Users/suzanmagic/Music/小幸运 (钢琴版) - 昼夜.mp3";
        String destFile = "/Users/suzanmagic/Downloads/小幸运 (钢琴版) - 昼夜.mp3";
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        byte[] buf = new byte[1024];
        int readLen = 0;
        try {
             bis = new BufferedInputStream(new FileInputStream(srcFile));
             bos = new BufferedOutputStream(new FileOutputStream(destFile));
             while((readLen = bis.read(buf)) != -1) {
                 bos.write(buf, 0, readLen);
             }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                bis.close();
            }
            if (bos != null) {
                bos.close();
            }
        }
    }
}
