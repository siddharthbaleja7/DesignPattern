package parkinglot;

import java.util.*;

public interface SpotAllocationStrategy {
   Optional<IParkingSpot> findSpot(List<IParkingSpot> spots, ParkingSpotType spotType);
}
