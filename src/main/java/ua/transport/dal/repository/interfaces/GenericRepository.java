package ua.transport.dal.repository.interfaces;

import java.util.List;

public interface GenericRepository<T> {
    List<T> findAll();
    T findById(Long id);
    void create(T entity);
    void update(T entity);
    void delete(Long id);
}