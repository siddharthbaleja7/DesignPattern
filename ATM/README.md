# ATM System - Object-Oriented Design


## Features

* **State Pattern** to manage the ATM's lifecycle and behavior through different states (e.g., Idle, Card Inserted, Authenticated).
* **Strategy Pattern** to flexibly handle various transaction types (Withdraw, Deposit, Balance Inquiry) as interchangeable algorithms.
* **Chain of Responsibility Pattern** for the cash dispenser to process withdrawal requests by dispensing the minimum number of currency notes.
* **Facade Pattern** to provide a single, simplified interface (the `ATM` class) to all the complex underlying subsystems like the card reader, printer, and bank services.
* **Singleton Pattern** to ensure only one instance of the `ATM` class exists, providing a global point of access.


## UML Diagram

The detailed UML class diagram is as below :-

![ATM System UML Diagram](https://github.com/siddharthbaleja7/DesignPattern/blob/main/ATM/ATM.png)
