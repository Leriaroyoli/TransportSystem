package ua.transport.dal.repository.interfaces;
import ua.transport.dal.entity.Route;

public interface RouteRepository extends GenericRepository<Route> {
    Route findByNumber(String number);
}
