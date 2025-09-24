package parkinglot;

public interface IParkingSpot {
    void occupySpot();
    void vacateSpot();
    boolean isAvailable();
    int getSpotId();
    ParkingSpotType getSpotType();
}