package parkinglot;

import java.util.*;

public class NearestSpotAllocationStrategy implements SpotAllocationStrategy {
    @Override
    public Optional<IParkingSpot> findSpot(List<IParkingSpot> spots, ParkingSpotType spotType) {
        for (IParkingSpot spot : spots) {
            if (spot.isAvailable() && spot.getSpotType() == spotType) {
                return Optional.of(spot);
            }
        }
        return Optional.empty();
    }
}