package pl.wsb.tanietaxi.ride.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/** Przejazd zamówiony przez pasażera, z ceną ustaloną przed wyjazdem. */
@Entity
@Table(name = "ride")
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Route route;

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private RideStatus status;

    @Column(name = "ordered_at", nullable = false)
    private LocalDateTime orderedAt;

    /** Ocena kierowcy 1–5, pusta dopóki pasażer nie oceni kursu. */
    @Column(name = "rating")
    private Integer rating;

    protected Ride() {
    }

    public Ride(Route route, BigDecimal price) {
        this.route = route;
        this.price = price;
        this.status = RideStatus.REQUESTED;
        this.orderedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public Route getRoute() {
        return route;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public RideStatus getStatus() {
        return status;
    }

    public LocalDateTime getOrderedAt() {
        return orderedAt;
    }

    public Integer getRating() {
        return rating;
    }
}
