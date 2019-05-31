package dao.interfaces;

import dao.entity.Model;

import java.util.List;

public interface ItemDAO<T extends Model> {

    List<T> getAll();

    T getById(long id);

    void add(T model);

    void update(T model);

    void remove(T model);

}
