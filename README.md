# Connect
Currently, many products are sold through intermediaries, such as wholesalers or retailers, which adds additional layers of cost and complexity to the supply chain. This can make it difficult for consumers to find the best prices and for manufacturers to reach their target market.
<br><br>Connect is a Core Java (Swing & AWT) based application  that connects manufacturers and consumers directly, eliminating the need for intermediaries and streamlining the supply chain. The application uses a MySQL database as the backend, and it was developed using Netbeans as part of DBMS Lab mini project.

## Features

- User registration and login
- Manufacturers can post their products
- Consumers can search for products
- Admin Panel for both vendors and consumers

## Installation

### Prerequisites

- [Java](https://www.java.com/en/download/)
- [MySQL](https://www.mysql.com/downloads/)
- [Netbeans](https://netbeans.org/downloads/)

### Step 1: Clone the repository
https://github.com/nooha01/Connect.git

### Step 2: Import the project in Netbeans

1. Open Netbeans
2. Go to `File > Open Project`
3. Navigate to the location where you cloned the repository and select the `Connect` folder
4. Click on `Open Project`

### Step 3: Set up the database

1. Create a new MySQL database and import the `connect.sql` file located in the `SQL` folder of the project
2. Update the `dbconfig.properties` file located in the `src/loginform/Connectionprovider.java` file with your database credentials

### Step 4: Run the application

1. In Netbeans, click on the `Run` button or press `Shift + F6`
2. The application should start and the Splash screen should appear

## Schema

The schema for this project can be found in the `SQL` folder in the root of the repository. The file is named `connect.sql`. You can download it and import it to your MySQL database to create the necessary tables and relationships.


## Team Members

- Akshay A P 
- Deepak P 
- Sanjay S J 
- Salihu Ahamed 
- Fathima Nooha Kottangodan 

