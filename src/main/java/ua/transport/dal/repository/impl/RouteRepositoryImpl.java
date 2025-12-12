package ua.transport.dal.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import ua.transport.dal.entity.Route;
import ua.transport.dal.repository.interfaces.RouteRepository;

public class RouteRepositoryImpl extends GenericRepositoryImpl<Route> implements RouteRepository {

    public RouteRepositoryImpl(EntityManager entityManager) {
        super(entityManager, Route.class);
    }

    @Override
    public Route findByNumber(String number) {
        try {
            return entityManager.createQuery("SELECT r FROM Route r WHERE r.routeNumber = :num", Route.class)
                    .setParameter("num", number)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
