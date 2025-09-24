package parkinglot;

import java.util.*;


public class ParkingLotSystem {
    public static void main(String[] args) throws InterruptedException {

        List<IParkingSpot> spots = new ArrayList<>();

        spots.add(new ParkingSpot(1, ParkingSpotType.MEDIUM));

        IParkingSpot evSpot = new ParkingSpot(2, ParkingSpotType.SMALL);
        spots.add(new ChargingSpotDecorator(evSpot));

        spots.add(new ParkingSpot(3, ParkingSpotType.SMALL));


        ParkingLot.builder()
                .withParkingSpots(spots)
                .withSpotAllocationStrategy(new NearestSpotAllocationStrategy())
                .withPricingStrategy(new HourlyPricingStrategy())
                .build();
        
        System.out.println("Parking Lot Initialized with Decorated Spots!");
        System.out.println("---");
        
        EntryGate entryGate = new EntryGate();
        ExitGate exitGate = new ExitGate();

        Optional<Ticket> smallTicketOpt = entryGate.generateTicket(ParkingSpotType.SMALL);

        if (smallTicketOpt.isPresent()) {
            Ticket smallTicket = smallTicketOpt.get();
            System.out.println("Small vehicle parked successfully. Spot: " + smallTicket.getParkingSpot().getSpotId());

            System.out.println("...parking for a short while...");
            Thread.sleep(2000); 

            exitGate.processExit(smallTicket);
        }
        System.out.println("---");
    }
}
