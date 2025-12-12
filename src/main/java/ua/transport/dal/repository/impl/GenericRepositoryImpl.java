package ua.transport.dal.repository.impl;

import jakarta.persistence.EntityManager;
import ua.transport.dal.repository.interfaces.GenericRepository;
import java.util.List;

public abstract class GenericRepositoryImpl<T> implements GenericRepository<T> {

    protected EntityManager entityManager;
    private Class<T> entityClass;

    public GenericRepositoryImpl(EntityManager entityManager, Class<T> entityClass) {
        this.entityManager = entityManager;
        this.entityClass = entityClass;
    }

    @Override
    public List<T> findAll() {
        return entityManager.createQuery("FROM " + entityClass.getSimpleName(), entityClass).getResultList();
    }

    @Override
    public T findById(Long id) {
        return entityManager.find(entityClass, id);
    }

    @Override
    public void create(T entity) {
        entityManager.persist(entity);
    }

    @Override
    public void update(T entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(Long id) {
        T entity = findById(id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }
}
