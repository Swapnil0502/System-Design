package ParkingLotSystem.strategies;

import ParkingLotSystem.entity.Ticket;
import ParkingLotSystem.enums.VehicleType;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class HourlyFareCalculationStrategy implements FareCalculationStrategy {

    private static final Map<VehicleType, Double> fares = new HashMap<>(
            Map.of(
                    VehicleType.BIKE, 20.00,
                    VehicleType.CAR, 50.00,
                    VehicleType.TRUCK, 100.00
            )
    );

    @Override
    public Double calculateFare(Ticket ticket) {

        Double price = fares.get(ticket.getVehicle().getVehicleType());

        LocalDateTime checkInTime = ticket.getDateTime();

        LocalDateTime checkOutTime = LocalDateTime.now();

        Duration duration = Duration.between(checkInTime, checkOutTime);

        long hours = (long) Math.ceil(duration.toMinutes() / 60.0);

        hours = Math.max(1, hours);

        return hours * price;
    }
}
