-- Table for storing user information
CREATE TABLE Passwords (
   username VARCHAR(255) NOT NULL,
   userid INT NOT NULL AUTO_INCREMENT,
   password VARCHAR(255) NOT NULL,
   PRIMARY KEY (userid)
);

-- Table for storing product information
CREATE TABLE Products (
   ProductID INT PRIMARY KEY,
   Name VARCHAR(25) NOT NULL,
   Description VARCHAR(25),
   Price INT NOT NULL,
   Quantity INT NOT NULL,
   VendorId INT,
   CategoryId INT,
   FOREIGN KEY (CategoryId) REFERENCES Category(CategoryId),
FOREIGN KEY (VendorId) REFERENCES Passwords(userid)
);

-- Table for storing orders information
CREATE TABLE Orders (
   OrderID INT PRIMARY KEY AUTO_INCREMENT,
   ProductID INT NOT NULL,
   CustomerID INT NOT NULL,
   Quantity INT NOT NULL,
   Price INT NOT NULL,
   Address VARCHAR(25) NOT NULL,
   Payment_Method VARCHAR(25) NOT NULL,
   FOREIGN KEY (ProductID) REFERENCES Products(ProductID),
   FOREIGN KEY (CustomerID) REFERENCES Passwords(Userid)
);

-- Table for storing review information
CREATE TABLE Review (
   ProductID INT NOT NULL,
   CustomerID INT NOT NULL,
   Rating INT NOT NULL,
   Comment VARCHAR(25),
   Date DATE NOT NULL,
   FOREIGN KEY (ProductID) REFERENCES Products(ProductID),
   FOREIGN KEY (CustomerID) REFERENCES Passwords(Userid)
);

-- Table for storing business information
CREATE TABLE business(
   bID INT,
   Name VARCHAR(25) NOT NULL,
   Description VARCHAR(25),
   Price INT NOT NULL,
   Quantity INT NOT NULL,
   VendorId INT,
   CategoryId INT

);

-- Table for storing Cetgory of products
CREATE TABLE Category (
   CategoryID INT PRIMARY KEY,
   Name VARCHAR(25) NOT NULL,
   Description TEXT
);

---INSERT VALUES:

INSERT INTO category (CategoryId, Name, Description) VALUES (1, 'Agriculture', 'Fruits, vegetables, seeds, and other products grown on farms');
INSERT INTO category (CategoryId, Name, Description) VALUES (2, 'Textile', 'Cloth, clothing and other fabrics');
INSERT INTO category (CategoryId, Name, Description) VALUES (3, 'Seeds', 'Seeds for various fruits and vegetables');
INSERT INTO category (CategoryId, Name, Description) VALUES (4, 'Wools', 'various wools for textile use');

INSERT INTO Passwords (username, password) VALUES ('RonWeasley', 'password789');
INSERT INTO Passwords (username, password) VALUES ('IndianaJones', 'password123');
INSERT INTO Passwords (username, password) VALUES ('LukeSkywalker', 'password456');
INSERT INTO Passwords (username, password) VALUES ('EllenRipley', 'password789');

INSERT INTO Products (ProductId, Name, Description, Price, Quantity, VendorId, CategoryId) VALUES (1, 'Golden Delicious Apples', 'Juicy and sweet', 2, 100, 1, 1);
INSERT INTO Products (ProductId, Name, Description, Price, Quantity, VendorId, CategoryId) VALUES (2, 'Navel Oranges', 'Juicy and sweet', 1.5, 50, 2, 1);
INSERT INTO Products (ProductId, Name, Description, Price, Quantity, VendorId, CategoryId) VALUES (3, 'Bananas', 'Organically Grown', 0.5, 25, 3, 1);
INSERT INTO Products (ProductId, Name, Description, Price, Quantity, VendorId, CategoryId) VALUES (4, 'Cotton T-Shirt', 'Regular fit, plain white', 10, 100, 1, 1);
INSERT INTO Products (ProductId, Name, Description, Price, Quantity, VendorId, CategoryId) VALUES (5, 'Silk Scarf', 'beautiful print', 15, 50, 2, 2);
INSERT INTO Products (ProductId, Name, Description, Price, Quantity, VendorId, CategoryId) VALUES (6, 'Tomato seeds', 'Heirloom Tomato seeds', 5, 100, 1, 3);
INSERT INTO Products (ProductId, Name, Description, Price, Quantity, VendorId, CategoryId) VALUES (7, 'Cucumber seeds', 'Organic Cucumber seeds', 6, 50, 2, 3);
INSERT INTO Products (ProductId, Name, Description, Price, Quantity, VendorId, CategoryId) VALUES (8, 'Merino Wool', 'Fine Merino wool yarn', 20, 100, 1, 4);

INSERT INTO Orders (ProductId, CustomerId, Quantity, Price, Address, Payment_Method) VALUES (1, 1, 2, 999, '123 Main St', 'Credit Card');
INSERT INTO Orders (ProductId, CustomerId, Quantity, Price, Address, Payment_Method) VALUES (2, 2, 1, 899, '456 Park Ave', 'PayPal');
INSERT INTO Orders (ProductId, CustomerId, Quantity, Price, Address, Payment_Method) VALUES (3, 3, 3, 1347, '789 Elm St', 'Cash on delivery');

