# Parking Lot Management System

## Problem Statement

Design a Parking Lot Management System that supports parking and unparking of vehicles in a multi-floor parking lot.

The system should be capable of:

- Parking vehicles and allocating an appropriate parking spot.
- Generating a parking ticket at the time of entry.
- Releasing the parking spot when the vehicle exits.
- Calculating parking fees based on the duration of parking and vehicle type.
- Supporting multiple floors and multiple parking spot types.
- Being extensible to support different spot allocation and pricing strategies in the future.

---

## Assumptions

- Parking lot consists of multiple floors.
- Each floor contains dedicated spots for Bike, Car, and Truck.
- A vehicle can only be parked in a matching spot type.
- Spot allocation strategy used: **First Available Spot**.
- Pricing strategy used: **Hourly Pricing**.
- Parking ticket is mandatory for vehicle exit.
- Lost ticket handling is not supported.
- Pre-booking of parking spots is not supported.
- Multiple pricing and allocation strategies may be added in future.

---

## Design Overview

### Entities

#### ParkingLot

Represents the entire parking lot.

- Contains multiple parking floors.

#### ParkingFloor

Represents a single floor in the parking lot.

- Contains a collection of parking spots.

#### ParkingSpot

Represents a parking space.

Stores:

- Spot ID
- Spot Type
- Occupancy Status
- Floor Number

#### Vehicle

Represents a vehicle entering the parking lot.

Stores:

- Vehicle Number
- Vehicle Type

#### Ticket

Generated when a vehicle is parked.

Stores:

- Ticket ID
- Vehicle Details
- Allocated Spot
- Check-in Time

#### Receipt

Generated when a vehicle exits.

Stores:

- Ticket ID
- Calculated Fare

---

## Design Patterns Used

### Strategy Pattern

Used to support extensible business rules without modifying existing code.

#### SpotAllocationStrategy

Responsible for finding a suitable parking spot.

Current implementation:

- FirstAvailableSpotAllocationStrategy

Possible future implementations:

- NearestSpotAllocationStrategy
- RandomSpotAllocationStrategy
- VIPSpotAllocationStrategy

#### FareCalculationStrategy

Responsible for calculating parking fees.

Current implementation:

- HourlyFareCalculationStrategy

Possible future implementations:

- WeekendPricingStrategy
- DynamicPricingStrategy
- FlatRatePricingStrategy

---

## Parking Flow

```text
Vehicle Enters
      |
      v
ParkingService
      |
      v
SpotAllocationStrategy
      |
      v
Available Spot Found
      |
      v
Mark Spot Occupied
      |
      v
Generate Ticket
      |
      v
Return Ticket
```

---

## Unparking Flow

```text
Vehicle Exits
      |
      v
Validate Ticket
      |
      v
Release Parking Spot
      |
      v
Calculate Fare
      |
      v
Generate Receipt
      |
      v
Return Receipt
```

---

## SOLID Principles Applied

### Single Responsibility Principle (SRP)

- ParkingService → parking operations
- SpotAllocationStrategy → spot allocation
- FareCalculationStrategy → fare calculation

### Open Closed Principle (OCP)

New allocation and pricing strategies can be added without modifying existing code.

### Dependency Inversion Principle (DIP)

ParkingService depends on abstractions:

- SpotAllocationStrategy
- FareCalculationStrategy

instead of concrete implementations.

---

## Current Limitations

- Spot allocation is not thread-safe.
- Concurrent parking requests may allocate the same spot.
- Lost ticket handling is not supported.
- Payment processing is not implemented.
- Entry and Exit Gate abstractions are not implemented.

---

## Future Enhancements

- Thread-safe spot allocation using AtomicBoolean.
- Concurrent ticket management using ConcurrentHashMap.
- Multiple entry and exit gates.
- Display board showing available spots.
- Online reservation support.
- EV charging spots.
- VIP parking support.
- Dynamic pricing support.
- Payment integration (UPI/Card/Cash).

---

## Project Structure

```text
ParkingLotSystem
│
├── entity
│   ├── ParkingLot
│   ├── ParkingFloor
│   ├── ParkingSpot
│   ├── Vehicle
│   ├── Ticket
│   └── Receipt
│
├── enums
│   ├── VehicleType
│   └── SpotType
│
├── strategies
│   ├── SpotAllocationStrategy
│   └── FareCalculationStrategy
│
├── service
│   ├── ParkingService
│   ├── FirstAvailableSpotAllocationStrategy
│   └── HourlyFareCalculationStrategy
│
└── client
    └── Client
```

---

## Key Learnings

- Applied Strategy Design Pattern.
- Designed a multi-floor parking lot hierarchy.
- Implemented parking and unparking workflows.
- Practiced SOLID principles.
- Understood concurrency challenges in resource allocation systems.
- Learned trade-offs between simplicity and extensibility.

---

## Sample Features Implemented

✅ Multi-floor Parking Lot

✅ Vehicle Parking

✅ Vehicle Unparking

✅ Ticket Generation

✅ Fare Calculation

✅ Strategy-Based Spot Allocation

✅ Strategy-Based Pricing

✅ Receipt Generation

---

## Author

This project was created as part of Low-Level Design (LLD) practice to strengthen object-oriented design, design patterns, SOLID principles, and backend system design skills.