package parkinglot;

import java.time.LocalDateTime;
import java.util.UUID;

public class Ticket {
    private final String ticketId;
    private final LocalDateTime entryTime;
    private final IParkingSpot parkingSpot;
    private final ParkingSpotType spotType;
    private double price;

    public Ticket(IParkingSpot parkingSpot) {
        this.ticketId = UUID.randomUUID().toString();
        this.entryTime = LocalDateTime.now();
        this.parkingSpot = parkingSpot;
        this.spotType = parkingSpot.getSpotType();
    }

    public String getTicketId() { return ticketId; }
    public LocalDateTime getEntryTime() { return entryTime; }
    public IParkingSpot getParkingSpot() { return parkingSpot; }
    public ParkingSpotType getSpotType() { return spotType; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}