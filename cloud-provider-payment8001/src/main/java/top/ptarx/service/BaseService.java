package top.ptarx.service;

import top.ptarx.entities.Pay;

import java.util.List;

public interface BaseService<T> {
    int add(T t);
    int delete(Integer id);

    int update(T t);

    T getById(Integer id);

    public List<T> getAll();
}
