package pl.wsb.tanietaxi.ride.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.math.BigDecimal;

/** Klasa wbudowana: kolumny trasy w tabeli przejazdu (bez własnej tabeli). */
@Embeddable
public class Route {

    @Column(name = "pickup_address", nullable = false, length = 120)
    private String pickupAddress;

    @Column(name = "destination_address", nullable = false, length = 120)
    private String destinationAddress;

    @Column(name = "distance_km", nullable = false, precision = 6, scale = 2)
    private BigDecimal distanceKm;

    protected Route() {
    }

    public Route(String pickupAddress, String destinationAddress, BigDecimal distanceKm) {
        this.pickupAddress = pickupAddress;
        this.destinationAddress = destinationAddress;
        this.distanceKm = distanceKm;
    }

    public String getPickupAddress() {
        return pickupAddress;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public BigDecimal getDistanceKm() {
        return distanceKm;
    }
}
