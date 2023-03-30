package assignment.chap15.q01;

import org.junit.jupiter.api.Test;

import java.util.List;

public class Homework01 {
    public static void main(String[] args) {

    }

    @Test
    public void test() {
        DAO<User> dao = new DAO<>();
        dao.save("1001", new User(11, 30, "lily"));
        dao.save("1002", new User(20, 33, "amy"));
        System.out.println("添加后\n" + dao);
        String id = "1002";
        System.out.println(id + "对应" + dao.get(id));
        dao.update("1001", new User(33, 24, "mary"));
        System.out.println("更新后\n" + dao);
        List<User> users = dao.list();
        System.out.println("全部value是\n" + users);
        dao.delete("1002");
        System.out.println("删除后\n" + dao);
    }
}
