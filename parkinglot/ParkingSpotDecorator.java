package parkinglot;

public abstract class ParkingSpotDecorator implements IParkingSpot {
    protected IParkingSpot decoratedSpot;

    public ParkingSpotDecorator(IParkingSpot spot) {
        this.decoratedSpot = spot;
    }

    @Override
    public void occupySpot() { decoratedSpot.occupySpot(); }
    @Override
    public void vacateSpot() { decoratedSpot.vacateSpot(); }
    @Override
    public boolean isAvailable() { return decoratedSpot.isAvailable(); }
    @Override
    public int getSpotId() { return decoratedSpot.getSpotId(); }
    @Override
    public ParkingSpotType getSpotType() { return decoratedSpot.getSpotType(); }
}