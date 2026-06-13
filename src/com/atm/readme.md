# ATM (Automated Teller Machine) LLD

## Overview

A comprehensive low-level design of an ATM system that handles cash withdrawals, deposits, balance inquiries, PIN changes, and transaction history. The system implements multiple design patterns including **State Pattern**, **Strategy Pattern**, and **Factory Pattern**.

---

## Scenario

**User:** John
**Card:** CARD001 (PIN: 1234)
**Account:** ACC001 (Balance: $10,000)
**Transaction:** Withdraw $1,300

---

## System Architecture

### Design Patterns Used

1. **State Pattern** - ATM transitions between different states based on user actions
2. **Strategy Pattern** - Different cash dispensing strategies (e.g., LeastNotesStrategy)
3. **Factory Pattern** - Creates transactions dynamically
4. **Singleton-like** - ATM maintains single instance with current state

---

## Core Components

### 1. **Models**

#### **ATM**
```
Attributes:
- currentState (ATMState)
- currentCard (Card)
- inventory (CashInventory)

Operations:
- getCurrentState()
- setState(ATMState)
- getCurrentCard()
- getInventory()
```

The ATM object is the context in the State Pattern. It starts in `IdleState`.

#### **Card**
```
Attributes:
- cardNumber (String)
- pin (int)
- account (Account)

Operations:
- validatePin(enteredPin)
- getAccount()
- setPin(newPin)
```

Represents a debit/credit card linked to a bank account.

#### **Account**
```
Attributes:
- accountNumber (String)
- balance (double)
- transactionHistory (List<Transaction>)

Operations:
- getBalance()
- debit(amount)
- credit(amount)
- getTransactionHistory()
```

Stores user's bank account details and balance.

#### **CashInventory**
```
Attributes:
- notes (Map<Integer, Integer>) - denomination -> count
  Example: {500: 20, 200: 20, 100: 20}

Operations:
- addNotes(denomination, count)
- removeNotes(denomination, count)
- getCount(denomination)
- getNotes() - returns all denominations
```

Maintains ATM's cash supply. Uses **TreeMap with reverse order** for denominations (highest first).

#### **Transaction**
```
Attributes:
- transactionId (String)
- type (TransactionType)
- amount (double)
- status (TransactionStatus)
- timestamp (LocalDateTime)
```

Records every ATM operation in the account's transaction history.

### 2. **Enums**

#### **TransactionType**
```
- CASH_WITHDRAWAL
- CASH_DEPOSIT
- BALANCE_INQUIRY
- PIN_CHANGE
```

#### **TransactionStatus**
```
- SUCCESS
- FAILED
- PENDING
```

### 3. **State Pattern - ATM States**

The ATM machine transitions between different states:

```
IdleState
    ↓
HasCardState (Card Inserted)
    ↓
[PIN Authenticated]
    ↓
SelectOperationState
    ├─ CASH_WITHDRAWAL → CashWithdrawalState
    ├─ BALANCE_INQUIRY → BalanceInquiryState
    ├─ CASH_DEPOSIT → CashDepositState
    └─ PIN_CHANGE → PinChangeState
    ↓
TransactionCompleteState
    ↓
IdleState (Eject Card)
```

#### **State Transitions**

**IdleState**
- Entry: ATM starts here
- Operation: `insertCard()`
- Exit: Transition to `HasCardState`

**HasCardState**
- Entry: Card inserted, stored in `atm.currentCard`
- Operation: `authenticatePin()`
- Exit: If PIN valid → `SelectOperationState`, else reject

**SelectOperationState**
- Entry: PIN authenticated
- Operation: `selectOperation(transactionType)`
- Exit: Route to appropriate state based on transaction type

**CashWithdrawalState**
- Entry: User selects withdrawal
- Operations:
  1. Check balance sufficiency
  2. Use `CashDispenseStrategy` to get note denominations
  3. Debit account
  4. Remove notes from inventory
  5. Print dispensed notes
- Exit: Transition to `TransactionCompleteState`

**BalanceInquiryState**
- Entry: User selects balance inquiry
- Operation: Display current balance
- Exit: Transition to `TransactionCompleteState`

**CashDepositState**
- Entry: User selects deposit
- Operation: Credit account with deposited amount
- Exit: Transition to `TransactionCompleteState`

**PinChangeState**
- Entry: User selects PIN change
- Operation: Update PIN on card
- Exit: Transition to `TransactionCompleteState`

**TransactionCompleteState**
- Entry: Transaction finished
- Operation: `ejectCard()`
- Exit: Return to `IdleState`

### 4. **Strategy Pattern - Cash Dispensing**

#### **CashDispenseStrategy Interface**
```java
Map<Integer,Integer> dispense(CashInventory inventory, int amount);
```

#### **LeastNotesStrategy** ✨

Dispenses cash using **minimum number of notes** (greedy approach):

```
Algorithm:
1. Iterate through denominations (highest first)
2. For each denomination:
   - Calculate required notes
   - Use minimum of (required, available)
   - Reduce remaining amount
3. If amount != 0 (not fully dispensed):
   - Throw "Cannot Dispense Amount"
```

**Example:**
```
Request: $1,300
Available: 500x20, 200x20, 100x20

Processing:
├─ $500: required=2, available=20 → use 2 → remaining=$300
├─ $200: required=1, available=20 → use 1 → remaining=$100
├─ $100: required=1, available=20 → use 1 → remaining=$0
└─ Success! Dispense 2×$500 + 1×$200 + 1×$100

Output:
500 → 2
200 → 1
100 → 1
```

**Validation:**
If required > available, uses **only available** (never overfills).

### 5. **Services**

#### **BankService**
```
Operations:
- withdraw(account, amount)
- deposit(account, amount)
- changePin(card, newPin)
```

Handles all account-related operations (debit, credit, PIN management).

#### **ReceiptService**
```
Operations:
- printReceipt(transaction)
```

Generates receipts for transactions.

#### **TransactionHistoryService**
```
Operations:
- addTransaction(account, transaction)
- getTransactionHistory(account)
```

Maintains and retrieves transaction records.

### 6. **Factory Pattern**

#### **TransactionFactory**
```
Operations:
- createTransaction(type, amount, accountNumber)
```

Creates `Transaction` objects dynamically based on transaction type and amount.

---

## Complete ATM Flow

### **Step 1: System Initialization**

```
└─ Create CashInventory
   ├─ Add notes: 500×20, 200×20, 100×20
   └─ Total: $18,000 in ATM

└─ Create Account
   ├─ Account Number: ACC001
   └─ Balance: $10,000

└─ Create Card
   ├─ Card Number: CARD001
   ├─ PIN: 1234
   └─ Linked Account: ACC001

└─ Create ATM
   ├─ Initialize with CashInventory
   └─ Set State: IdleState
```

### **Step 2: Insert Card**

```
Current State: IdleState

atm.getCurrentState().insertCard(atm, card)
         ↓
IdleState.insertCard()
    ├─ Store card: atm.setCurrentCard(card)
    ├─ Transition: atm.setState(HasCardState)
    └─ Print: "Card Inserted"

New State: HasCardState
```

### **Step 3: Authenticate PIN**

```
Current State: HasCardState

atm.getCurrentState().authenticatePin(atm, 1234)
         ↓
HasCardState.authenticatePin()
    ├─ Validate: card.validatePin(1234)
    ├─ If valid:
    │  └─ Transition: atm.setState(SelectOperationState)
    │     Print: "PIN Authenticated"
    └─ If invalid:
       └─ Eject card, throw exception

New State: SelectOperationState
```

### **Step 4: Select Operation**

```
Current State: SelectOperationState

atm.getCurrentState().selectOperation(
    atm,
    TransactionType.CASH_WITHDRAWAL
)
         ↓
SelectOperationState.selectOperation()
    ├─ Switch on TransactionType
    └─ Case CASH_WITHDRAWAL:
       └─ Transition: atm.setState(CashWithdrawalState)

New State: CashWithdrawalState
```

### **Step 5: Withdraw Cash ($1,300)**

```
Current State: CashWithdrawalState

atm.getCurrentState().withdrawCash(atm, 1300)
         ↓
CashWithdrawalState.withdrawCash()
    │
    ├─ Step 5a: Validate Balance
    │  ├─ Get account: card.getAccount()
    │  ├─ Current Balance: $10,000
    │  ├─ Requested: $1,300
    │  └─ Check: $10,000 >= $1,300 ✓
    │
    ├─ Step 5b: Dispense Strategy
    │  ├─ Call strategy.dispense(inventory, 1300)
    │  └─ LeastNotesStrategy processes:
    │     ├─ $500: 2 notes → $1,000 (remaining: $300)
    │     ├─ $200: 1 note → $200 (remaining: $100)
    │     ├─ $100: 1 note → $100 (remaining: $0)
    │     └─ Result: {500→2, 200→1, 100→1}
    │
    ├─ Step 5c: Debit Account
    │  ├─ bankService.withdraw(account, 1300)
    │  └─ New Balance: $10,000 - $1,300 = $8,700
    │
    ├─ Step 5d: Update Inventory
    │  ├─ Remove 2× $500 notes
    │  ├─ Remove 1× $200 note
    │  ├─ Remove 1× $100 note
    │  └─ New Inventory: 500×18, 200×19, 100×19
    │
    ├─ Step 5e: Print Dispensed Notes
    │  ├─ "Dispensing Cash:"
    │  ├─ "500 → 2"
    │  ├─ "200 → 1"
    │  └─ "100 → 1"
    │
    └─ Step 5f: Transition
       └─ atm.setState(TransactionCompleteState)

New State: TransactionCompleteState
```

### **Step 6: Eject Card**

```
Current State: TransactionCompleteState

atm.getCurrentState().ejectCard(atm)
         ↓
TransactionCompleteState.ejectCard()
    ├─ Clear card: atm.setCurrentCard(null)
    ├─ Transition: atm.setState(IdleState)
    └─ Print: "Card Ejected"

New State: IdleState
```

### **Step 7: Display Result**

```
Output:
┌─────────────────────────────────┐
│ Card Inserted                   │
│ PIN Authenticated               │
│ Dispensing Cash:                │
│ 500 → 2                         │
│ 200 → 1                         │
│ 100 → 1                         │
│ Card Ejected                    │
│ Remaining Balance : 8700.0      │
└─────────────────────────────────┘
```

---

## Complete Sequence Diagram

```
Main
 │
 ├─ Create ATM (State: IdleState)
 │
 ├─ insertCard(card)
 │  │
 │  └─ IdleState.insertCard()
 │     ├─ setCurrentCard(card)
 │     ├─ setState(HasCardState)
 │     └─ Print: "Card Inserted"
 │
 ├─ authenticatePin(1234)
 │  │
 │  └─ HasCardState.authenticatePin()
 │     ├─ Validate PIN
 │     ├─ setState(SelectOperationState)
 │     └─ Print: "PIN Authenticated"
 │
 ├─ selectOperation(CASH_WITHDRAWAL)
 │  │
 │  └─ SelectOperationState.selectOperation()
 │     ├─ Switch on CASH_WITHDRAWAL
 │     └─ setState(CashWithdrawalState)
 │
 ├─ withdrawCash(1300)
 │  │
 │  └─ CashWithdrawalState.withdrawCash()
 │     ├─ Check Balance: $10,000 >= $1,300 ✓
 │     ├─ Dispense Strategy
 │     │  ├─ LeastNotesStrategy.dispense()
 │     │  └─ Result: {500→2, 200→1, 100→1}
 │     ├─ BankService.withdraw(account, 1300)
 │     ├─ Remove notes from inventory
 │     ├─ Print: "Dispensing Cash: 500→2, 200→1, 100→1"
 │     └─ setState(TransactionCompleteState)
 │
 ├─ ejectCard()
 │  │
 │  └─ TransactionCompleteState.ejectCard()
 │     ├─ setCurrentCard(null)
 │     ├─ setState(IdleState)
 │     └─ Print: "Card Ejected"
 │
 └─ Print Remaining Balance: $8,700
```

---

## Error Handling Scenarios

### **Scenario 1: Insufficient Balance**
```
Request: Withdraw $15,000
Balance: $10,000

Action:
└─ CashWithdrawalState checks balance
   ├─ $10,000 < $15,000
   ├─ Print: "Insufficient Balance"
   └─ Return without debit
```

### **Scenario 2: Insufficient Inventory**
```
Request: Withdraw $1,300
ATM has: 500×0, 200×2, 100×3
Total in ATM: $800

Action:
└─ LeastNotesStrategy processes:
   ├─ $500: required=2, available=0 → skip
   ├─ $200: required=6, available=2 → use 2 (remaining=$900)
   ├─ $100: required=9, available=3 → use 3 (remaining=$600)
   └─ Remaining=$600 != 0
   └─ Throw: "Cannot Dispense Amount"
```

### **Scenario 3: Invalid PIN**
```
Request: PIN 9999 (Actual: 1234)

Action:
└─ HasCardState.authenticatePin()
   ├─ card.validatePin(9999) → false
   ├─ Eject card
   └─ Throw: "Invalid PIN"
```

### **Scenario 4: Card Already Inserted**
```
Action:
└─ IdleState only supports insertCard()
└─ Other operations throw: "UnsupportedOperationException"
```

---

## Key Features

✅ **State Pattern** - Clear separation of ATM states and transitions
✅ **Strategy Pattern** - Flexible cash dispensing algorithms
✅ **Thread-safe PIN validation** - Secure PIN handling
✅ **Strong validation** - Balance checks, denomination availability
✅ **Transaction tracking** - Complete transaction history
✅ **Graceful error handling** - Meaningful error messages
✅ **Inventory management** - Real-time cash tracking
✅ **Multiple operations** - Withdrawal, Deposit, Balance, PIN Change

---

## Data Flow Summary

```
┌─────────────────────────────────────────────────────────────┐
│                     ATM System Flow                         │
├─────────────────────────────────────────────────────────────┤
│                                                             │
│  Card Insertion → PIN Validation → Operation Selection    │
│       ↓                ↓                    ↓              │
│    IdleState      HasCardState       SelectOperationState  │
│                                                             │
│                    ┌─── Withdrawal ─────────┐              │
│                    │      (Strategy)         │              │
│                    ├─── Deposit ────────────┤              │
│                    ├─── Balance Inquiry ────┤              │
│                    └─── PIN Change ────────┘              │
│                            ↓                               │
│                  TransactionCompleteState                 │
│                            ↓                               │
│                      Card Eject                            │
│                            ↓                               │
│                      Return to Idle                        │
│                                                             │
└─────────────────────────────────────────────────────────────┘
```

---

## Design Principles Applied

1. **Single Responsibility** - Each state handles only its operations
2. **Open/Closed Principle** - Easy to add new cash dispensing strategies
3. **Dependency Inversion** - Depend on abstractions (ATMState, CashDispenseStrategy)
4. **DRY** - Reusable services (BankService, ReceiptService)
5. **Fail-Safe** - Comprehensive error handling at each step

---

## Testing Recommendations

- Test valid withdrawal scenario
- Test insufficient balance scenario
- Test invalid PIN scenario
- Test insufficient cash inventory scenario
- Test all transaction types (Deposit, Balance, PIN Change)
- Test card ejection in various states
- Test transaction history recording

