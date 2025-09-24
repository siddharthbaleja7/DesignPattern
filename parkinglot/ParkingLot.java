package parkinglot;

import java.util.*;

public class ParkingLot {
    private static ParkingLot instance;
    private final List<IParkingSpot> parkingSpots;
    private final SpotAllocationStrategy spotAllocationStrategy;
    private final PricingStrategy pricingStrategy;

    private ParkingLot(Builder builder) {
        this.parkingSpots = builder.parkingSpots;
        this.spotAllocationStrategy = builder.spotAllocationStrategy;
        this.pricingStrategy = builder.pricingStrategy;
    }
    
    public static ParkingLot getInstance() {
        if (instance == null) throw new IllegalStateException("ParkingLot is not initialized.");
        return instance;
    }

    public Optional<Ticket> parkVehicle(ParkingSpotType spotType) {
        Optional<IParkingSpot> spotOptional = spotAllocationStrategy.findSpot(parkingSpots, spotType);
        if (spotOptional.isPresent()) {
            IParkingSpot spot = spotOptional.get();
            spot.occupySpot();
            Ticket ticket = new Ticket(spot);
            return Optional.of(ticket);
        }
        System.out.println("Sorry, parking lot is full for type: " + spotType);
        return Optional.empty();
    }

    public double unparkVehicle(Ticket ticket) {
        double price = pricingStrategy.calculatePrice(ticket);
        ticket.getParkingSpot().vacateSpot();
        System.out.println("Vehicle from spot " + ticket.getParkingSpot().getSpotId() + " unparked. Fee: ₹" + price);
        return price;
    }


    public static class Builder { 
        private List<IParkingSpot> parkingSpots;
        private SpotAllocationStrategy spotAllocationStrategy;
        private PricingStrategy pricingStrategy;

        public Builder withParkingSpots(List<IParkingSpot> spots) { this.parkingSpots = spots; return this; }
        public Builder withSpotAllocationStrategy(SpotAllocationStrategy s) { this.spotAllocationStrategy = s; return this; }
        public Builder withPricingStrategy(PricingStrategy p) { this.pricingStrategy = p; return this; }
        public void build() { if (instance == null) instance = new ParkingLot(this); }
    }
     public static Builder builder() { return new Builder(); }
}