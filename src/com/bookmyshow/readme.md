# BookMyShow Main Flow

## Scenario
- User: Bhanu
- Movie: Pushpa 3
- Theater: PVR Hyderabad
- Seats Selected: A1, A2

## Step 1: Application Startup

In Main.java we first create all dependencies:

```
Repositories
    ↓
Services
    ↓
Factories
    ↓
BookingService
```

**Dependencies Created:**
- BookingRepository, TicketRepository
- PaymentService, SeatLockService, TicketService, NotificationService
- BookingFactory

At this point the system is ready.

## Step 2: Create Master Data

Setup/admin data:
- **Movie**: Pushpa 3
- **Theater**: PVR Hyderabad
- **Screen**: Screen-1
- **Seats**: A1, A2, A3

## Step 3: Create Show

A movie runs at a specific time:
- Pushpa 3 @ 10:00 AM on Screen-1

**Why Show?** The same movie can run multiple times (10 AM, 2 PM, 6 PM shows).

## Step 4: Create ShowSeats

Physical seats become ShowSeats for a particular show:

```
A1 AVAILABLE 200
A2 AVAILABLE 200
A3 AVAILABLE 200
```

Each ShowSeat has: Seat, Status, Price

## Step 5: User Selects Seats

Bhanu chooses: A1, A2

```java
List<ShowSeat> selectedSeats = List.of(showSeat1, showSeat2);
```

## Step 6: Call BookingService

```java
bookingService.bookTicket(bhanu, show, selectedSeats);
```

Everything below happens inside BookingService.

## Step 7: Lock Seats

Before:
```
A1 AVAILABLE
A2 AVAILABLE
```

After:
```
A1 LOCKED
A2 LOCKED
```

**Why Lock?** Prevents double-booking when multiple users select same seat simultaneously.

## Step 8: Calculate Amount

```
A1 = 200
A2 = 200
Total = 400
```

## Step 9: Payment

PaymentService flow:
```
Select Gateway
    ↓
RazorPay
    ↓
Pay
    ↓
Payment Successful: 400
```

## Step 10: Mark Seats Booked

Before:
```
A1 LOCKED
A2 LOCKED
```

After:
```
A1 BOOKED
A2 BOOKED
```

Now nobody else can reserve them.

## Step 11: Create Booking

BookingFactory creates:
```
Booking
--------
BookingId: B123
User: Bhanu
Show: Pushpa 3 @ 10 AM
Seats: A1, A2
Amount: 400
Status: CONFIRMED
```

## Step 12: Save Booking

Stored in Map<String, Booking> (or DB in production).

## Step 13: Generate Ticket

TicketService creates:
```
Ticket
------
TicketId: T123
Movie: Pushpa 3
Theater: PVR Hyderabad
Screen: Screen-1
Seats: A1, A2
Show Time: 10:00 AM
```

## Step 14: Save Ticket

TicketRepository saves for future retrieval.

## Step 15: Send Notifications

NotificationService sends via:
- EmailNotifier
- SMSNotifier
- WhatsAppNotifier

Output:
```
Email Sent
SMS Sent
WhatsApp Sent
```

## Step 16: Return Booking

BookingService returns Booking to Main.

## Step 17: Display Result

```
===== BOOKING SUCCESS =====
Booking Id: B123
Movie: Pushpa 3
Amount: 400
Status: CONFIRMED
=============================
```

## Complete Sequence Diagram

```
Main
 ├─ bookTicket()
 │
 └─ BookingService
    ├─ lockSeats() → SeatLockService → LOCKED
    ├─ calculateAmount() → 400
    ├─ paymentService.pay() → Payment Success
    ├─ markSeatsBooked() → BOOKED
    ├─ bookingFactory.createBooking() → Booking
    ├─ bookingRepository.save() → Stored
    ├─ ticketService.generateTicket() → Ticket
    ├─ notificationService.sendConfirmation() → Email/SMS/WhatsApp
    └─ Return Booking
       │
       └─ Main → Print Success
```
