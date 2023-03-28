package assignment.chap14;

import java.util.ArrayList;
import java.util.Collections;

public class Homework01 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(new News("Perennial rice: Plant once, harvest again and again"));
        list.add(new News("5 planets could be visible in the night sky next week"));
        list.add(new News("woo!!!"));

        Collections.reverse(list);
        for (Object o : list) {
            if (o instanceof News) {
                String title = ((News) o).getTitle();
                System.out.println(processTitle(title));
            }
        }
    }

    public static String processTitle(String str) {
        if (str == null)
            return "";
        StringBuilder show = new StringBuilder();
        if (str.length() > 15) {
            show.append(str, 0, 15).append("...");
            return show.toString();
        } else
            return str;
    }
}

class News {
    private String title;
    private String content;

    public News(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                '}';
    }
}
