README - Milestone 1
Project: Smart Bike Sharing Platform

1. Project Overview

This project is a console-based prototype for a Smart Bike Sharing Platform.
It simulates a small urban/campus bike-rental system where a user can register, reserve bikes, start and finish rides, and receive notifications.
The goal is to demonstrate several design patterns in a working proof-of-concept (PoC), not to build a full production system.

2. Scope (Proof of Concept)

The PoC will include:

User registration and simple login (in-memory).

Stations and bikes with availability tracking.

Reservation - start - finish trip flow.

Dynamic pricing using different strategies (time, distance, or peak hours).

Simulated payment (no real API).

Notifications for reservation and trip events (Observer pattern).

Operator actions: mark a bike as under maintenance or return it to service.

Out of scope (for simplicity):

No real database or network.

No GUI / mobile UI (console only).

No GPS or maps.

No external services or microservices (yet).

3. Functional Requirements (summary)

User: register, view stations, reserve a bike, start and finish a ride.

Operator: set bike status to maintenance or available.

Pricing: calculate final price according to selected strategy.

Notifications: inform users when a reservation or trip changes state.

4. Selected Design Patterns and Justification
  1) State Pattern

Used for: the bike lifecycle (Available - Reserved - InUse - Maintenance).

Why: each state defines different allowed actions.

Benefit: removes large if-else blocks and makes adding new states easier.

  2) Strategy Pattern

Used for: the ride-pricing algorithm.

Why: pricing may depend on time, distance, or hour of day.

Benefit: algorithms are interchangeable at runtime and independent of core logic.

  3) Observer Pattern

Used for: notifications to users and operators.

Why: multiple listeners must react to events independently.

Benefit: decouples event emitters from receivers; easy to extend later (UI, logs, etc.).

  4) Factory Method / Abstract Factory

Used for: creating service objects (e.g. PaymentService, NotificationChannel, Bike types).

Why: allows switching between mock and real implementations without code changes.

Benefit: centralized object creation and clear separation of concerns.

  (Optional) Facade Pattern

Mentioned as a possible future improvement to group external services behind a single interface.

Not implemented in the PoC to keep the scope realistic and focused on the core four patterns.

5. Pattern - Use Case Mapping
Use Case	Patterns Applied
Reserve Bike	State transition validation + Factory creates Reservation + Observer sends notification
Start Ride	State Reserved - InUse + Observer notification
Finish Ride	State InUse - Available + Strategy computes price + Factory creates PaymentService + Observer sends receipt
Maintenance Mode	State forces - Maintenance + Observer notifies operator

6. Domain Model (High-Level)

Main classes and relations:

User, Bike, Station, Reservation, Trip

BikeState (subclasses for each state)

PricingStrategy interface + implementations

NotificationCenter (Observer publisher)

PaymentServiceFactory (Factory pattern)

All data will be kept in memory during execution - no real database.

7. Technology

Language: Java 17

Execution: Console application (no GUI)

Testing: Basic manual tests + possible JUnit 5 in later milestones

Goal: Demonstrate clear use of design patterns and good architecture

8. Repository and Milestones

Since this is an individual project, all code and documentation are developed by Carlos Garcia.

GitHub branches:

1-project-and-patterns → This README

2-uml-and-poc-implementation → UML diagrams + first code prototype

3-architectures-comparison → Monolith vs Microservices comparison

4-microservices-implementation → future implementation

5-queue-and-cicd → future work

The repository must be public to be graded.

9. Summary

This project implements a simple but well-structured bike-sharing system using four core design patterns (State, Strategy, Observer, Factory).
The optional Facade pattern is acknowledged but not implemented in the PoC to keep the scope feasible for a solo developer.
The goal is clarity, correct pattern usage, and a functional console demonstration in later milestones.