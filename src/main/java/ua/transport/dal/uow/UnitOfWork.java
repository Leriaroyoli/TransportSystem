package ua.transport.dal.uow;

import ua.transport.dal.repository.interfaces.RouteRepository;
import ua.transport.dal.repository.interfaces.TransportUnitRepository;

public interface UnitOfWork extends AutoCloseable {
    RouteRepository getRouteRepository();
    TransportUnitRepository getTransportUnitRepository();
    void commit();
}