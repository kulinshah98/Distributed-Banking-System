# Distributed Banking System

Implemented a Distributed Banking System.

## Compile and Run

- Compile all java files using 'javac *.java' command
- Run server file using 'java Server_201501234' command 
- Run client file using 'java Client_201501234' command

## Functionality

- `deposit (ACCOUNT NUMBER, AMOUNT)`: Increase the balance of the given account number by given amount and returns confirmation with transaction id.
- `withdraw (ACCOUNT NUMBER, AMOUNT)`: Decrease the balance of the given account number by given amount and returns confirmation with transaction id.
- `balance (ACCOUNT NUMBER)`: Gives the account balance.
- `transaction_details (ACCOUNT NUMBER, START DATE, END DATE)`: Return the Transaction History for transactions based only on the date range.

## Extension

Can add SMS Feature. When a user deposit or withdraw money, a message should be sent to the mobile phone of the user.

- Each client's mobile will start a RMI server on it's own and then bind with the server.
- We will store the port or ip or contact info of the client.
- There will be a function of notification in the Interface.
- Now as transaction occurs server will call the function notification.
- Now server will act as client for the RMI server of mobile for the account and call the notification function from interface with the details of transaction.
- In this function notification the RMI server which is actually client's mobile can print the message notifying the user of transaction.


