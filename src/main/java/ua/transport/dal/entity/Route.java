package ua.transport.dal.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "routes")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "route_number", nullable = false)
    private String routeNumber;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "route", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<TransportUnit> transportUnits = new ArrayList<>();


    public Route() {
    }

    public Route(String routeNumber, String description) {
        this.routeNumber = routeNumber;
        this.description = description;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRouteNumber() { return routeNumber; }
    public void setRouteNumber(String routeNumber) { this.routeNumber = routeNumber; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<TransportUnit> getTransportUnits() { return transportUnits; }
    public void setTransportUnits(List<TransportUnit> transportUnits) { this.transportUnits = transportUnits; }

    @Override
    public String toString() {
        return "Route{id=" + id + ", number='" + routeNumber + "', desc='" + description + "'}";
    }

    public void addTransportUnit(TransportUnit transportUnit) {
        transportUnits.add(transportUnit);
    }
}
