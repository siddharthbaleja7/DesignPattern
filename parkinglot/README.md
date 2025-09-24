# Parking Lot System


## Features

- Builder pattern for flexible construction of ParkingLot configurations.
- Strategy pattern to flexibly change pricing and spot allocation algorithms.
- Decorator pattern to extend parking spot functionality without modifying existing code.
- Support for various parking spot types and vehicle types.
- Includes components for Entry and Exit gates, Tickets, and dynamic spot allocation.

## System Components

- **ParkingLot**: Class managing parking spots, pricing, and spot allocation.
- **ParkingSpot & IParkingSpot**: Interface and concrete classes including decorators for spots with extra features.
- **EntryGate & ExitGate**: Interfaces for issuing and processing tickets.
- **PricingStrategy & SpotAllocationStrategy**: Interfaces with concrete implementations for flexible pricing and allocation.
- **Ticket**: Represents a parking session with references to spots and vehicles.
- **Builder**: Inner builder class to create and configure ParkingLot instances.
- **Decorator Classes**: Extending ParkingSpot functionality with decorators like ChargingSpotDecorator.

## UML Diagram

The detailed UML class diagram showcasing the system architecture, relationships, and design patterns can be viewed here:

[Parking Lot System UML Diagram](https://github.com/siddharthbaleja7/DesignPattern/blob/main/parkinglot/Image.png)

