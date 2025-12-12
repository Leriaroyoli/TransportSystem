package ua.transport.dal.repository.impl;

import jakarta.persistence.EntityManager;
import ua.transport.dal.entity.TransportUnit;
import ua.transport.dal.repository.interfaces.TransportUnitRepository;

public class TransportUnitRepositoryImpl extends GenericRepositoryImpl<TransportUnit> implements TransportUnitRepository {

    public TransportUnitRepositoryImpl(EntityManager entityManager) {
        super(entityManager, TransportUnit.class);
    }
}
