package parkinglot;

public class ExitGate {
    public double processExit(Ticket ticket) {
        return ParkingLot.getInstance().unparkVehicle(ticket);
    }
}