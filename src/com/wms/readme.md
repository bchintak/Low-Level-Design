# Warehouse Management System (WMS) - README

This document describes the Warehouse Management System (LLD) implementation under the `com.wms` package.

## Purpose

A minimal, modular design to manage products, inventory in a warehouse, order placement/reservation, allocation strategy, notifications and simple state transitions for orders.

## Key Concepts & Components

- Models
  - `Product` — productId, name, price
  - `Inventory` — a product + available quantity (add/remove stock)
  - `Warehouse` — warehouseId, address and a map of productId → `Inventory`
  - `OrderItem` — product + quantity requested
  - `Order` — orderId, list of `OrderItem`s and internal `OrderState`
  - `Address` — simple address model

- Services
  - `InventoryService` — add stock to warehouse and reserve stock (decrement quantity)
  - `OrderService` — places order and reserves required stock using `InventoryService`

- Strategy
  - `InventoryAllocationStrategy` — interface for choosing a warehouse for an order
  - `MaxInventoryStrategy` — example implementation: picks the warehouse that has the maximum stock for the requested product

- State Pattern (Order lifecycle)
  - `Order` keeps an `OrderState` implementation
  - State classes: `CreatedState`, `ReservedState`, `ShippedState`, `CancelledState`
  - Methods like `reserve()`, `ship()`, `cancel()` delegate to the current state

- Observer & Notification
  - `InventoryObserver` interface (e.g., `EmailAlertObserver`) — receives inventory change alerts
  - `NotificationService` interface with implementations (`EmailNotification`, `SMSNotification`) and `NotificationFactory` for creation

## Main Flow (example in `Main.java`)

1. Create `Product`(s).
2. Create a `Warehouse` with an `Address`.
3. Add inventory to the warehouse using `warehouse.addInventory(product, qty)` (or through `InventoryService`).
4. Create `OrderItem` and `Order` (list of items).
5. Create services: `InventoryService` and `OrderService` (injected with an `InventoryAllocationStrategy`).
6. `OrderService.placeOrder(order, warehouse)`:
   - For each `OrderItem`, call `inventoryService.reserveStock(warehouse, product, qty)`
   - If reservation succeeds for all items, call `order.reserve()` which transitions order state
7. `order.ship()` transitions the order to shipped (state change) when appropriate.
8. Send notifications via `NotificationService` created from `NotificationFactory`.

Example (from `Main.java`):

- Create a `Laptop` product and a warehouse `WH1` with stock 50.
- Place an order of quantity 2 → reservation reduces stock to 48.
- Ship the order and send email notification.

## How to compile & run (PowerShell)

Recommended: compile all sources together so inter-file dependencies are resolved:

```powershell
Push-Location "C:\Users\BhanuPrakashChintaka\IdeaProjects\LLD"
if(-Not (Test-Path out)) { New-Item -ItemType Directory -Path out | Out-Null }
$files = Get-ChildItem -Path .\src -Recurse -Filter *.java | Select-Object -ExpandProperty FullName
javac -d out $files
java -cp out com.wms.Main
Pop-Location
```

Or compile only `Main.java` while letting the compiler find other sources:

```powershell
javac -d out -sourcepath src src\com\wms\Main.java
java -cp out com.wms.Main
```

## Design Notes

- Simplicity: classes are small and focused on single responsibilities.
- Strategy Pattern: `InventoryAllocationStrategy` allows different allocation policies (e.g., max stock, nearest warehouse).
- State Pattern: `Order` delegates lifecycle behavior to state objects.
- Observer Pattern: inventory observers can react to inventory changes and trigger alerts/notifications.

## Limitations & Extension Ideas

- Current `OrderService.placeOrder()` reserves stock directly from the warehouse passed in; a real system would use `InventoryAllocationStrategy` to pick from multiple warehouses.
- No transactional/rollback logic when partial reservations fail — add atomic reservation or compensation logic.
- No persistence; data is in-memory (maps). Integrate a DB or repository layer for persistence.
- Add concurrency controls for multi-threaded ordering scenarios.
- Add inventory thresholds and automatic reordering via observer notifications.

## Files of interest

- `com.wms.Main` — example runner
- `com.wms.model.*` — domain models
- `com.wms.service.InventoryService`, `com.wms.service.OrderService`
- `com.wms.strategy.*` — allocation strategies
- `com.wms.state.*` — order state implementations
- `com.wms.observer.*` and `com.wms.notification.*` — observer and notification components

---
Use this README as a starting point to understand and extend the WMS implementation.

