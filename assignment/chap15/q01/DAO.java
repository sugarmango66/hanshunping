package assignment.chap15.q01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DAO <T>{
    private Map<String, T> map;

    public DAO() {
        map = new HashMap<>();
    }

    public void save(String id, T entity) {
        map.put(id, entity);
    }
    public T get(String id) {
        return map.get(id);
    }
    public void update(String id, T entity) {
        map.put(id, entity);
    }
    public List<T> list() {
        return new ArrayList<>(map.values());
    }
    public void delete(String id) {
        map.remove(id);
    }

    @Override
    public String toString() {
        return "DAO{" +
                "map=" + map +
                '}';
    }
}
