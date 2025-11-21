Milestone 3 – Investigation and Evaluation of Three Software Architectures

This milestone investigates how the Smart Bike Sharing Platform could be implemented using three different software architectures:

Monolithic architecture

Microservices architecture

Event-driven architecture

For each architecture, I describe the structure of the system, provide component and deployment diagrams, evaluate pros and cons, and then compare all three to select the most suitable architecture for this project.

1. Monolithic Architecture
1.1 Structure and Data Flow

In a monolithic architecture, the entire application is deployed as one single unit running in one process.
A realistic monolithic design for this project includes:

Presentation layer: web/mobile API endpoints.

Application layer: services that handle use cases (reserve bike, start ride, finish ride).

Domain layer: core business logic (Bike, Station, Trip, State, Strategy, Observer, Factory).

Persistence layer: one relational database storing all data.

Data flow example – Finish ride:

Client sends HTTP request POST /trips/{id}/finish.

TripService updates the bike state and calculates the price using a PricingStrategy.

Payment is processed through a PaymentService.

Notification is sent to the user.

Data is saved to a single database.

1.2 Component Diagram (Monolithic)

![alt text](<Component diagram Monolit-1.png>)

1.3 Deployment Diagram (Monolithic)

![alt text](<Deployment diagram Monolit-1.png>)

1.4 Pros and Cons
Pros

Very simple to build and deploy — ideal for a single developer.

Easy to maintain and debug — all logic in one place.

Strong consistency (one process, one database).

Perfect fit for an educational proof-of-concept.

Cons

Can become harder to maintain as it grows larger.

Cannot scale individual features independently.

Full redeploy required after every change.

Technology lock-in (same language, same DB).

2. Microservices Architecture
2.1 Structure and Data Flow

In a microservices architecture, the system is split into independent services with their own databases.
A reasonable breakdown for the project:

API Gateway

User Service

Bike & Station Service

Trip & Pricing Service

Notification Service

Payment Service

Each service is deployed independently and communicates through HTTP or lightweight messaging.

Data flow example – Finish ride:

Gateway routes request to Trip Service.

Trip Service calls Bike Service to update bike status.

Trip Service calls Payment Service to process payment.

Trip Service notifies Notification Service to alert the user.

2.2 Component Diagram (Microservices)

![alt text](<Component diagram Microservices-1.png>)

2.3 Deployment Diagram (Microservices)

![alt text](<Deployment diagram Microservices-1.png>)

2.4 Pros and Cons
Pros

Highly modular and scalable.

Each service can be developed and deployed independently.

Good fault isolation.

Suitable for large teams and production-scale deployments.

Cons

Much more complex for one student.

Requires DevOps knowledge (containers, monitoring, orchestration).

Debugging is more difficult (distributed logs).

Risk of over-engineering for a small system.

3. Event-driven Architecture
3.1 Structure and Data Flow

Event-driven architecture uses asynchronous events as the main communication mechanism.
A message broker (Kafka/RabbitMQ) connects services.

Example events:

BikeReserved

RideStarted

RideFinished

TripPriced

PaymentCompleted

Services publish and consume events through the message broker.

Data flow example – Finish ride:

Bike Service publishes RideFinished.

Trip Service consumes it, calculates price, publishes TripPriced.

Payment Service consumes TripPriced, processes payment, publishes PaymentCompleted.

Notification Service sends messages to the user.

This fits naturally with the existing Observer pattern in the code.

3.2 Component Diagram (Event-driven)

![alt text](<Component diagram Event-Driven-1.png>)

3.3 Deployment Diagram (Event-driven)

![alt text](<Deployment diagram Event-driven-1.png>)

3.4 Pros and Cons
Pros

Very flexible and loosely coupled.

Easy to extend with new event consumers (analytics, monitoring…).

Matches the nature of the bike-sharing domain (lots of events).

Scales very well in production.

Cons

Requires managing a message broker (Kafka/RabbitMQ).

Harder to debug due to asynchronous behavior.

Eventual consistency (not all updates happen instantly).

Too advanced for a single-developer student project.

4. Comparison and Final Decision
Monolithic

✔ Best simplicity

✔ Easiest to implement

✔ Perfect for solo developer

✖ Limited scalability

Microservices

✔ Highly modular

✔ Good scalability

✖ Requires complex infrastructure

✖ Heavy for this project scope

Event-driven

✔ Very decoupled and elegant

✔ Ideal for high-scale systems

✖ Requires message broker

✖ Adds unnecessary complexity for a simple prototype

5. Final Choice

I choose the Monolithic Architecture as the most suitable option for my Smart Bike Sharing Platform.

Reasons:

It is the most realistic for a single developer in a short academic project.

It allows focusing on the internal design patterns (State, Strategy, Observer, Factory).

It avoids unnecessary infrastructure overhead.

It can always be evolved into microservices or event-driven systems in the future.