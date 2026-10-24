package pl.wsb.tanietaxi.pricing.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;

/** Cennik, z którego liczona jest cena kursu z góry: opłata startowa + stawka za kilometr. */
@Entity
@Table(name = "tariff")
public class Tariff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 40)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "vehicle_class", nullable = false, length = 20)
    private VehicleClass vehicleClass;

    @Column(name = "base_fare", nullable = false, precision = 10, scale = 2)
    private BigDecimal baseFare;

    @Column(name = "price_per_km", nullable = false, precision = 10, scale = 2)
    private BigDecimal pricePerKm;

    @Column(name = "valid_from", nullable = false)
    private LocalDate validFrom;

    protected Tariff() {
    }

    public Tariff(String name, VehicleClass vehicleClass, BigDecimal baseFare, BigDecimal pricePerKm, LocalDate validFrom) {
        this.name = name;
        this.vehicleClass = vehicleClass;
        this.baseFare = baseFare;
        this.pricePerKm = pricePerKm;
        this.validFrom = validFrom;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public VehicleClass getVehicleClass() {
        return vehicleClass;
    }

    public BigDecimal getBaseFare() {
        return baseFare;
    }

    public BigDecimal getPricePerKm() {
        return pricePerKm;
    }

    public LocalDate getValidFrom() {
        return validFrom;
    }
}
