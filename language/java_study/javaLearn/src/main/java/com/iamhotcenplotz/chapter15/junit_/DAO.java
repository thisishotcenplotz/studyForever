package com.iamhotcenplotz.chapter15.junit_;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class DAO<T> {
    private Map<String,T> map = new HashMap<>();

    public T get(String id) {
        return map.get(id);
    }

    public void update(String id, T t) {
        map.put(id, t);
    }

    public List<T> getAll() {
        ArrayList<T> t = new ArrayList<>();
        for (String key :map.keySet()) {
            t.add(get(key));
        }
        return t;
    }

    public void delete(String id) {
        map.remove(id);
    }

    public void save(String id, T t) {
        map.put(id, t);
    }
}
