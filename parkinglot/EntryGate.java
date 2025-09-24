package parkinglot;
import java.util.*;

public class EntryGate {
    public Optional<Ticket> generateTicket(ParkingSpotType spotType) {
        System.out.println("A vehicle requiring a " + spotType + " spot is entering...");
        return ParkingLot.getInstance().parkVehicle(spotType);
    }
}