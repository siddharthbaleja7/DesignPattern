package parkinglot;

public class ParkingSpot implements IParkingSpot {
    private final int spotId;
    private final ParkingSpotType spotType;
    private boolean isAvailable;

    public ParkingSpot(int spotId, ParkingSpotType spotType) {
        this.spotId = spotId;
        this.spotType = spotType;
        this.isAvailable = true;
    }

    public void occupySpot() {
        this.isAvailable = false;
    }

    public void vacateSpot() {
        this.isAvailable = true;
    }
    
    public int getSpotId() { return spotId; }
    public ParkingSpotType getSpotType() { return spotType; }
    public boolean isAvailable() { return isAvailable; }
}
