package parkinglot;

public class ChargingSpotDecorator extends ParkingSpotDecorator {

    public ChargingSpotDecorator(IParkingSpot spot) {
        super(spot);
    }

    @Override
    public void occupySpot() {
        super.occupySpot();
        startCharging();
    }

    @Override
    public void vacateSpot() {
        stopCharging();
        super.vacateSpot();
    }

    private void startCharging() {
        System.out.println("Spot " + getSpotId() + ": EV charging started.");
    }
    
    private void stopCharging() {
        System.out.println("Spot " + getSpotId() + ": EV charging stopped.");
    }
}
