# Vending Machine (LLD) - README

This document explains the design and main flow of the Vending Machine low-level design implementation found under the `com.vendingmachine` package.

## Overview

The vending machine project models a simple coin-operated vending machine that holds products on shelves, accepts coins, dispenses products, and returns change. The implementation focuses on clear separation of responsibilities and simple, testable components.

## Key Components

- `model`:
  - `Product` — id, name, price
  - `ItemShelf` — shelf id, product, quantity

- `inventory`:
  - `Inventory` — manages collection of `ItemShelf`s and provides lookup/add/remove operations

- `machine`:
  - `VendingMachine` — core class: accepts coins, tracks balance, selects product, dispenses product and change

- `enums`:
  - `Coin` — supported coin denominations (e.g., TEN, TWENTY, etc.)

## Main Flow (high level)

1. Application creates `Product` instances and populates `Inventory` with `ItemShelf`s (shelf id, product, count).
2. `VendingMachine` is constructed with the `Inventory` instance.
3. User inserts coins by calling `insertCoin(Coin)` (internal balance increases).
4. User selects product by shelf id via `selectProduct(shelfId)`.
   - Machine checks if shelf exists and has stock.
   - Machine checks if inserted balance is sufficient.
   - If sufficient: dispense product, reduce shelf count, compute and return change.
   - If insufficient: reject selection or prompt for more coins.

## Example

See `com.vendingmachine.MainTest` — it demonstrates a typical run:

- Create `Product("P1","Coke", 20)`
- Add `ItemShelf(101, coke, 5)` to `Inventory`
- Create `VendingMachine(inventory)`
- Insert two `Coin.TEN` coins and select product `101`

Expected output (from `MainTest`):

```
Dispensed : Coke
Change : 0
```

## How to compile & run (PowerShell)

Compile entire project (recommended):

```powershell
Push-Location "C:\Users\BhanuPrakashChintaka\IdeaProjects\LLD"
if(-Not (Test-Path out)) { New-Item -ItemType Directory -Path out | Out-Null }
$files = Get-ChildItem -Path .\src -Recurse -Filter *.java | Select-Object -ExpandProperty FullName
javac -d out $files
java -cp out com.vendingmachine.MainTest
Pop-Location
```

Or compile only `MainTest` and let the compiler find other sources via `-sourcepath`:

```powershell
javac -d out -sourcepath src src\com\vendingmachine\MainTest.java
java -cp out com.vendingmachine.MainTest
```

## Design patterns & principles used

- Single Responsibility: `Inventory`, `VendingMachine`, and model classes each have clear responsibilities.
- Dependency Injection (via constructors) to make testing and composition easier.

## Extension ideas

- Add coin inventory to track change and refuse transactions when exact change cannot be returned.
- Add item price categories and multiple coin types.
- Add REST front-end or CLI wrapper for interactive testing.

## Notes

- The project is intentionally small and focused on clarity over performance. Edge conditions (e.g., exact change not available) should be added based on requirements.

---
Created for the LLD exercise. Use `MainTest` as a minimal runner to exercise the flow.

