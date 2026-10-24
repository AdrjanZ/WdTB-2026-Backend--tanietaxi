package pl.wsb.tanietaxi.fleet.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import pl.wsb.tanietaxi.pricing.entity.VehicleClass;

/** Samochód używany do realizacji przejazdów. Na LAB 02 bez relacji z kierowcą. */
@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand", nullable = false, length = 40)
    private String brand;

    @Column(name = "model", nullable = false, length = 60)
    private String model;

    @Column(name = "registration_number", nullable = false, unique = true, length = 20)
    private String registrationNumber;

    /** Liczba miejsc dla pasażerów, bez miejsca kierowcy. */
    @Column(name = "seats", nullable = false)
    private Integer seats;

    @Enumerated(EnumType.STRING)
    @Column(name = "vehicle_class", nullable = false, length = 20)
    private VehicleClass vehicleClass;

    /** Czy samochód jest dopuszczony do obsługi kursów, niezależnie od zajętości. */
    @Column(name = "active", nullable = false)
    private Boolean active;

    protected Vehicle() {
    }

    public Vehicle(String brand, String model, String registrationNumber, Integer seats, VehicleClass vehicleClass) {
        this.brand = brand;
        this.model = model;
        this.registrationNumber = registrationNumber;
        this.seats = seats;
        this.vehicleClass = vehicleClass;
        this.active = true;
    }

    public Long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public Integer getSeats() {
        return seats;
    }

    public VehicleClass getVehicleClass() {
        return vehicleClass;
    }

    public Boolean getActive() {
        return active;
    }
}
