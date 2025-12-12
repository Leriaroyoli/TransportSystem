package ua.transport.dal.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "transport_units")
public class TransportUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "license_plate", nullable = false)
    private String licensePlate;

    @Column(name = "type")
    private String type;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;

    public TransportUnit() {
    }

    public TransportUnit(String licensePlate, String type) {
        this.licensePlate = licensePlate;
        this.type = type;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getLicensePlate() { return licensePlate; }
    public void setLicensePlate(String licensePlate) { this.licensePlate = licensePlate; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public Route getRoute() { return route; }
    public void setRoute(Route route) { this.route = route; }

    // helper method for bidirectional relationship
    public void addRoute(Route route) {
        if (route == null) {
            return;
        }
        setRoute(route);
        route.addTransportUnit(this);
    }

    @Override
    public String toString() {
        return "Transport{id=" + id + ", plate='" + licensePlate + "', type='" + type + "'}";
    }
}