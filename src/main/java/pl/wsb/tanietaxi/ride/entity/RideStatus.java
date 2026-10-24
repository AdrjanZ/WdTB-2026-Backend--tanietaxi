package pl.wsb.tanietaxi.ride.entity;

/** Etap przejazdu: od zamówienia do zakończenia albo anulowania. */
public enum RideStatus {
    REQUESTED,
    ACCEPTED,
    COMPLETED,
    CANCELLED
}
