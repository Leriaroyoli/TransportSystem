package ua.transport.dal.uow;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import ua.transport.dal.repository.impl.RouteRepositoryImpl;
import ua.transport.dal.repository.impl.TransportUnitRepositoryImpl;
import ua.transport.dal.repository.interfaces.RouteRepository;
import ua.transport.dal.repository.interfaces.TransportUnitRepository;

public class UnitOfWorkImpl implements UnitOfWork {

    private final EntityManagerFactory emf;
    private final EntityManager entityManager;

    private RouteRepository routeRepository;
    private TransportUnitRepository transportUnitRepository;

    public UnitOfWorkImpl() {
        this.emf = Persistence.createEntityManagerFactory("TransportPU");
        this.entityManager = emf.createEntityManager();
        this.entityManager.getTransaction().begin();
    }

    @Override
    public RouteRepository getRouteRepository() {
        if (routeRepository == null) {
            routeRepository = new RouteRepositoryImpl(entityManager);
        }
        return routeRepository;
    }

    @Override
    public TransportUnitRepository getTransportUnitRepository() {
        if (transportUnitRepository == null) {
            transportUnitRepository = new TransportUnitRepositoryImpl(entityManager);
        }
        return transportUnitRepository;
    }

    @Override
    public void commit() {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().commit();
        }
        entityManager.getTransaction().begin();
    }

    @Override
    public void close() {
        if (entityManager.isOpen()) entityManager.close();
        if (emf.isOpen()) emf.close();
    }
}
