package parkinglot;

import java.time.Duration;
import java.time.LocalDateTime;

public class HourlyPricingStrategy implements PricingStrategy {
    private static final double SMALL_SPOT_RATE = 30.0;
    private static final double MEDIUM_SPOT_RATE = 50.0;
    private static final double LARGE_SPOT_RATE = 80.0;

    @Override
    public double calculatePrice(Ticket ticket) {

        double hourlyRate;
        ParkingSpotType spotType = ticket.getSpotType();

        switch (spotType) {
            case SMALL:
                hourlyRate = SMALL_SPOT_RATE;
                break;
            case MEDIUM:
                hourlyRate = MEDIUM_SPOT_RATE;
                break;
            case LARGE:
                hourlyRate = LARGE_SPOT_RATE;
                break;
            default:
                throw new IllegalArgumentException("Unsupported spot type for pricing: " + spotType);
        }


        LocalDateTime exitTime = LocalDateTime.now();
        Duration duration = Duration.between(ticket.getEntryTime(), exitTime);
        

        long hours = (long) Math.ceil(duration.toMinutes() / 60.0);
        if (hours == 0) hours = 1; 
        

        double price = hours * hourlyRate;
        ticket.setPrice(price);
        
        System.out.println("Rate Applied: ₹" + hourlyRate + "/hr for " + hours + " hour(s).");
        return price;
    }
}