# Java ATM Simulator

A simple console-based ATM program written in Java. It supports multiple accounts, each with its own account number, PIN, and balance.

> **For learning purposes only.** All accounts, PINs, and balances in this project are sample data.

## Features

- Log in using an account number and a 4-digit PIN
- Limited PIN attempts (the program stops when attempts run out)
- Check balance
- Withdraw money (amount must be a multiple of 100 and not more than the balance)
- Deposit money (amount must be a multiple of 100, maximum of 500,000 per transaction)
- Receipt after every successful withdraw or deposit
- Loading bar animation
- Input validation (letters, empty input, and invalid choices will not crash the program)
- Log out and switch to another account without restarting the program

## Concepts Practiced

- Classes, objects, and constructors
- Arrays of objects
- Methods and attributes
- Loops (`while`, `do-while`) and conditions
- Input validation using `try-catch` and regex
- Formatted output using `printf`

## Project Structure

```
.
├── Accounts.java   # Account class (ID, name, PIN, balance) and its transactions
├── ATMv2.java      # Main program: login page and main menu
└── README.md
```

## How to Run

**Requirements:** JDK 11 or higher

1. Clone the repository:
   ```
   git clone <your-repository-url>
   cd <your-repository-folder>
   ```
2. Compile:
   ```
   javac Accounts.java ATMv2.java
   ```
3. Run:
   ```
   java ATMv2
   ```

> Tip: use a terminal that supports UTF-8 so the box borders and loading bar display correctly.

## Sample Accounts

| Account Number | PIN  | Starting Balance |
|----------------|------|------------------|
| 1001           | 1234 | 5,000            |
| 1002           | 1444 | 6,000            |
| 1003           | 1543 | 7,000            |
| 1004           | 1236 | 8,000            |
| 1005           | 2468 | 9,000            |

## Sample Flow

```
ENTER ACCOUNT NUMBER [OR 0 TO EXIT]:
>> 1001
ENTER PIN [0 TO EXIT]:
>> 1234

[1] CHECK BALANCE      [3] DEPOSIT
[2] WITHDRAW           [4] LOG OUT
```

## Future Improvements

- Change PIN
- Transfer money between accounts
- Transaction history
- Make the account fields `private` and use getters and methods
- Save accounts to a file so balances are kept after closing the program
