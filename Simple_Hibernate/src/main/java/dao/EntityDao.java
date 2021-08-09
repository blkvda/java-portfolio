package dao;

import java.util.List;

public interface EntityDao<T> {
    void add(T obj);
    T findById(long id);
    List<T> findAll();
    void update(T obj);
}
