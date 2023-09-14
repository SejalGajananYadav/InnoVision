create database OrderProcessing;
use  OrderProcessing;

CREATE TABLE Customers (
    CustomerID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(255) NOT NULL,
    GSTNumber VARCHAR(15) NOT NULL,
    Address VARCHAR(255) NOT NULL,
    City VARCHAR(100) NOT NULL,
    Email VARCHAR(255) NOT NULL,
    Phone VARCHAR(15) NOT NULL,
    PinCode VARCHAR(10) NOT NULL
);
ALTER TABLE Customers
ADD Password varchar(8) not null;
delete from Customers;

INSERT INTO Customers (Name, GSTNumber, Address, City, Email, Phone, PinCode,Password) VALUES
('John Doe', 'GST12345', '123 Main Street', 'Mumbai', 'john@example.com', '8234567890', '400001','@Joh8234'),
('Jane Smith', 'GST67890', '456 Oak Avenue', 'Delhi', 'jane@example.com', '9876543210', '110001','@Jan9876'),
('Michael Johnson', 'GST24680', '789 Elm Road', 'Kolkata', 'michael@example.com', '8765432109', '700001','@Mic8765'),
('Emily Brown', 'GST13579', '101 Pine Lane', 'Chennai', 'emily@example.com', '7654321098', '600001','@Emi7654'),
('David Lee', 'GST54321', '222 Birch Street', 'Hyderabad', 'david@example.com', '7543210987', '500001','@Dav7543'),
('Sophia Wilson', 'GST98765', '333 Maple Avenue', 'Bengaluru', 'sophia@example.com', '9432109876', '560001','@Sop9432'),
('William Davis', 'GST24681', '444 Cedar Road', 'Pune', 'william@example.com', '9321098765', '411001','@Wil9321'),
('Olivia White', 'GST13579', '555 Redwood Lane', 'Ahmedabad', 'olivia@example.com', '8210987654', '380001','@Oli8210'),
('James Martin', 'GST12345', '666 Sequoia Street', 'Jaipur', 'james@example.com', '9109876543', '302001','@Jam9109'),
('Ava Harris', 'GST13579', '777 Sycamore Avenue', 'Lucknow', 'ava@example.com', '7098765432', '226001','@Ava7098'),
('Ethan Patel', 'GST24681', '888 Fir Lane', 'Kanpur', 'ethan@example.com', '7987654321', '208001','@Eth7987'),
('Mia Kumar', 'GST54321', '999 Cedar Road', 'Nagpur', 'mia@example.com', '9876543210', '440001','@Mia9876'),
('Liam Singh', 'GST98765', '111 Oak Street', 'Indore', 'liam@example.com', '8765432109', '452001','@Lia8765'),
('Charlotte Sharma', 'GST13579', '222 Maple Avenue', 'Chandigarh', 'charlotte@example.com', '7654321098', '160001','@Cha7654'),
('Noah Gupta', 'GST12345', '333 Pine Lane', 'Patna', 'noah@example.com', '6543210987', '800001','@Noa6543'),
('Ava Verma', 'GST13579', '444 Birch Street', 'Varanasi', 'ava@example.com', '7432109876', '221001','@Ava7432'),
('Liam Reddy', 'GST24681', '555 Cedar Road', 'Agra', 'liam@example.com', '7321098765', '282001','@Lia7321'),
('Emma Choudhury', 'GST98765', '666 Redwood Lane', 'Bhopal', 'emma@example.com', '8210987654', '462001','@Emm8210'),
('Isabella Khan', 'GST54321', '777 Sequoia Street', 'Ludhiana', 'isabella@example.com', '9109876543', '141001','@Isa9109'),
('Lucas Sharma', 'GST13579', '888 Sycamore Avenue', 'Coimbatore', 'lucas@example.com', '9098765432', '641001','@Luc9098');
select * from Customers;
CREATE TABLE Company (
	CompanyId int AUTO_INCREMENT PRIMARY KEY,
    CompanyName VARCHAR(255) NOT NULL,
    Address VARCHAR(255) NOT NULL,
    City VARCHAR(100) NOT NULL,
    GSTNumber VARCHAR(15) NOT NULL
);

INSERT INTO Company (CompanyName, Address, City, GSTNumber) VALUES
('Indian Textiles', '123 Fabric Street', 'Mumbai', 'GSTIN12345'),
('Silk Emporium', '456 Silk Lane', 'Delhi', 'GSTIN67890'),
('Cotton Creations', '789 Cotton Road', 'Jaipur', 'GSTIN24680'),
('Elegant Ethnic', '101 Ethnic Avenue', 'Bengaluru', 'GSTIN13579'),
('Saree Palace', '222 Silk Street', 'Chennai', 'GSTIN54321'),
('Traditional Threads', '333 Tradition Road', 'Hyderabad', 'GSTIN98765'),
('Silk & Sari', '444 Silk Lane', 'Kolkata', 'GSTIN11111'),
('Saree World', '555 Saree Avenue', 'Ahmedabad', 'GSTIN22222'),
('Ethnic Essence', '666 Essence Street', 'Pune', 'GSTIN33333'),
('Artistic Attire', '777 Artistic Road', 'Lucknow', 'GSTIN44444'),
('Indian Fabrics', '888 Fabric Lane', 'Kanpur', 'GSTIN55555'),
('Graceful Garments', '999 Garment Avenue', 'Nagpur', 'GSTIN66666'),
('Royal Raiment', '111 Royal Road', 'Varanasi', 'GSTIN77777'),
('Ethereal Embroidery', '222 Embroidery Street', 'Patna', 'GSTIN88888'),
('Vibrant Vesture', '333 Vesture Road', 'Agra', 'GSTIN99999'),
('Regal Robes', '444 Regal Avenue', 'Bhopal', 'GSTIN12345'),
('Colorful Couture', '555 Couture Lane', 'Ludhiana', 'GSTIN13579'),
('Traditional Trends', '666 Trendy Street', 'Coimbatore', 'GSTIN24681'),
('Elegance Emporium', '777 Elegance Road', 'Chandigarh', 'GSTIN98765'),
('Sari Splendor', '888 Sari Avenue', 'Indore', 'GSTIN54321');

select * from Company;
CREATE TABLE Employees (
    EmployeeID INT AUTO_INCREMENT PRIMARY KEY,
    UserName VARCHAR(50) NOT NULL,
    Password VARCHAR(255) NOT NULL,
    CompanyId int ,
	FOREIGN KEY (CompanyId) REFERENCES Company(CompanyId)
	ON DELETE CASCADE  -- Delete cascading
    ON UPDATE CASCADE  -- Update cascading
);

select * from Employees;

-- Employees for Company 1 (Indian Textiles)
INSERT INTO Employees (UserName, Password, CompanyId) VALUES
('employee1_it', 'password123', 1),
('employee2_it', 'securepass', 1);

-- Employees for Company 2 (Silk Emporium)
INSERT INTO Employees (UserName, Password, CompanyId) VALUES
('employee1_se', 'silkpass', 2),
('employee2_se', 'secretpass', 2);

-- Employees for Company 3 (Cotton Creations)
INSERT INTO Employees (UserName, Password, CompanyId) VALUES
('employee1_cc', 'cotton123', 3),
('employee2_cc', 'pass123', 3);

-- Employees for Company 4 (Elegant Ethnic)
INSERT INTO Employees (UserName, Password, CompanyId) VALUES
('employee1_ee', 'ethenicpass', 4),
('employee2_ee', 'secureee', 4);

-- Employees for Company 5 (Saree Palace)
INSERT INTO Employees (UserName, Password, CompanyId) VALUES
('employee1_sp', 'sareepass', 5),
('employee2_sp', 'securepass', 5);

-- Employees for Company 6 (Traditional Threads)
INSERT INTO Employees (UserName, Password, CompanyId) VALUES
('employee1_tt', 'tradition123', 6),
('employee2_tt', 'ttsecure', 6);

-- Employees for Company 7 (Silk & Sari)
INSERT INTO Employees (UserName, Password, CompanyId) VALUES
('employee1_ss', 'silkandsari', 7),
('employee2_ss', 'silk123', 7);

-- Employees for Company 8 (Saree World)
INSERT INTO Employees (UserName, Password, CompanyId) VALUES
('employee1_sw', 'worldpass', 8),
('employee2_sw', 'secureworld', 8);

-- Employees for Company 9 (Ethnic Essence)
INSERT INTO Employees (UserName, Password, CompanyId) VALUES
('employee1_ee', 'ethnicessence', 9),
('employee2_ee', 'ee123', 9);

-- Employees for Company 10 (Artistic Attire)
INSERT INTO Employees (UserName, Password, CompanyId) VALUES
('employee1_aa', 'artistic123', 10),
('employee2_aa', 'aasecure', 10);

CREATE TABLE Products (
    ProductID INT  PRIMARY KEY,
    ProductName VARCHAR(255),
    Price DECIMAL(10, 2),
    Category varchar(7),
    CompanyID INT,  -- Foreign key referencing Company
    FOREIGN KEY (CompanyID) REFERENCES Company(CompanyID)
);

-- Products for Company 1 (Indian Textiles)
INSERT INTO Products (ProductID,ProductName, Price, CompanyID) VALUES
(1,'Cotton Saree', 1500.00, 1),
(2,'Silk Kurta', 1200.00, 1),
(3,'Ethnic Shawl', 800.00, 1);

-- Products for Company 2 (Silk Emporium)
INSERT INTO Products (ProductID,ProductName, Price, CompanyID) VALUES
(4,'Silk Saree', 2000.00, 2),
(5,'Embroidered Lehenga', 2500.00, 2),
(6,'Silk Scarf', 500.00, 2);

-- Products for Company 3 (Cotton Creations)
INSERT INTO Products (ProductID,ProductName, Price, CompanyID) VALUES
(7,'Cotton Shirt', 800.00, 3),
(8,'Casual Trousers', 900.00, 3),
(9,'Cotton Dress', 1200.00, 3);

-- Products for Company 4 (Elegant Ethnic)
INSERT INTO Products (ProductID,ProductName, Price, CompanyID) VALUES
(10,'Ethnic Saree', 1800.00, 4),
(11,'Anarkali Suit', 1600.00, 4),
(12,'Ethnic Jewelry Set', 500.00, 4);

-- Products for Company 5 (Saree Palace)
INSERT INTO Products (ProductID,ProductName, Price, CompanyID) VALUES
(13,'Designer Saree', 2800.00, 5),
(14,'Printed Kurti', 1200.00, 5),
(15,'Embroidered Blouse', 600.00, 5);

-- Products for Company 6 (Traditional Threads)
INSERT INTO Products (ProductID,ProductName, Price, CompanyID) VALUES
(16,'Traditional Lehenga', 2200.00, 6),
(17,'Silk Dupatta', 750.00, 6),
(18,'Cotton Kurta', 900.00, 6);

-- Products for Company 7 (Silk & Sari)
INSERT INTO Products (ProductID,ProductName, Price, CompanyID) VALUES
(19,'Banarasi Silk Sari', 3200.00, 7),
(20,'Sari Blouse', 500.00, 7),
(21,'Embroidered Silk Stole', 800.00, 7);

-- Products for Company 8 (Saree World)
INSERT INTO Products (ProductID,ProductName, Price, CompanyID) VALUES
(22,'Designer Wedding Saree', 3500.00, 8),
(23,'Cotton Silk Saree', 1800.00, 8),
(24,'Sari Accessories Set', 600.00, 8);

-- Products for Company 9 (Ethnic Essence)
INSERT INTO Products (ProductID,ProductName, Price, CompanyID) VALUES
(25,'Ethnic Gown', 2100.00, 9),
(26,'Kalamkari Dupatta', 850.00, 9),
(27,'Embroidered Ethnic Kurti', 1100.00, 9);

-- Products for Company 10 (Artistic Attire)
INSERT INTO Products (ProductID,ProductName, Price, CompanyID) VALUES
(28,'Artistic Print Saree', 2600.00, 10),
(29,'Casual Artistic Top', 950.00, 10),
(30,'Artistic Shawl', 700.00, 10);

-- Products for Company 11 (High Fashion Couture)
INSERT INTO Products (ProductID,ProductName, Price, CompanyID) VALUES
(31,'Designer Bridal Gown', 15000.00, 11),
(32,'Luxury Silk Saree', 18000.00, 11),
(33,'Hand-Embroidered Lehenga', 22000.00, 11);

-- Products for Company 12 (Royal Outfits)
INSERT INTO Products (ProductID,ProductName, Price, CompanyID) VALUES
(34,'Royal Wedding Sherwani', 12000.00, 12),
(35,'Exquisite Velvet Sari', 16000.00, 12),
(36,'Embellished Royal Cape', 13000.00, 12);

-- Products for Company 13 (Fashionista Boutique)
INSERT INTO Products (ProductID,ProductName, Price, CompanyID) VALUES
(37,'Trendy Designer Kurti', 11000.00, 13),
(38,'High-Fashion Tuxedo', 14000.00, 13),
(39,'Chic Couture Dress', 15000.00, 13);

-- Products for Company 14 (Elegant Ensemble)
INSERT INTO Products (ProductID,ProductName, Price, CompanyID) VALUES
(40,'Elegant Evening Gown', 16000.00, 14),
(41,'Stylish Designer Suit', 13000.00, 14),
(42,'Luxury Embroidered Shawl', 11000.00, 14);

-- Products for Company 15 (Classy Creations)
INSERT INTO Products (ProductID,ProductName, Price, CompanyID) VALUES
(43,'Classy Business Suit', 12000.00, 15),
(44,'Exclusive Party Dress', 15000.00, 15),
(45,'Chic Embroidered Kurti', 11000.00, 15);

-- Products for Company 16 (Luxury Couture)
INSERT INTO Products (ProductID,ProductName, Price, CompanyID) VALUES
(46,'Luxury Wedding Gown', 55000.00, 16),
(47,'Exquisite Silk Ensemble', 48000.00, 16),
(48,'Handcrafted Embellished Sari', 42000.00, 16);

-- Products for Company 17 (Premium Attire)
INSERT INTO Products (ProductID,ProductName, Price, CompanyID) VALUES
(49,'Premium Wedding Sherwani', 45000.00, 17),
(50,'Elegant Bridal Lehenga', 52000.00, 17),
(51,'Luxury Velvet Suit', 48000.00, 17);

-- Products for Company 18 (High-End Elegance)
INSERT INTO Products (ProductID,ProductName, Price, CompanyID) VALUES
(52,'High-End Evening Gown', 49000.00, 18),
(53,'Designer Tuxedo Collection', 45000.00, 18),
(54,'Couture Embroidered Cape', 42000.00, 18);

-- Products for Company 19 (Royal Couturiers)
INSERT INTO Products (ProductID,ProductName, Price, CompanyID) VALUES
(55,'Royal Wedding Ensemble', 55000.00, 19),
(56,'Regal Velvet Sari', 48000.00, 19),
(57,'Embellished Royal Robe', 42000.00, 19);

-- Products for Company 20 (Haute Couture Creations)
INSERT INTO Products (ProductID,ProductName, Price, CompanyID) VALUES
(58,'Haute Couture Business Suit', 45000.00, 20),
(59,'Luxury Party Dress Collection', 52000.00, 20),
(60,'Chic Embroidered Luxury Kurti', 42000.00, 20);

CREATE TABLE Orders (
    OrderID INT AUTO_INCREMENT PRIMARY KEY,
    OrderDate DATE NOT NULL,
    CustomerID INT NOT NULL,
    CustomerShippingAddress VARCHAR(255) NOT NULL,
    TotalOrderValue DECIMAL(10, 2) NOT NULL,
    ShippingCost DECIMAL(10, 2) NOT NULL,
    ShippingAgency VARCHAR(100) NOT NULL,
    -- Status ENUM('Pending', 'Approved', 'Completed', 'Expired') NOT NULL,
	Status VARCHAR(15) NOT NULL,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
	ON DELETE CASCADE  -- Delete cascading
    ON UPDATE CASCADE  -- Update cascading
);

CREATE TABLE OrderProducts (
    OrderProductID INT AUTO_INCREMENT PRIMARY KEY,
    OrderID INT NOT NULL,
    ProductID INT NOT NULL,
    Quantity INT NOT NULL,
    FOREIGN KEY (OrderID) REFERENCES Orders(OrderID),
    FOREIGN KEY (ProductID) REFERENCES Products(ProductID)
	ON DELETE CASCADE  -- Delete cascading
    ON UPDATE CASCADE  -- Update cascadingcompanycustomers
);

CREATE TABLE Invoices (
    InvoiceID INT AUTO_INCREMENT PRIMARY KEY,
    InvoiceDate DATE NOT NULL,
    OrderID INT NOT NULL,
    CustomerID INT NOT NULL,
    TypeOfGST  varchar(20) NOT NULL,
    TotalGSTAmount DECIMAL(10, 2) NOT NULL,
    TotalInvoiceValue DECIMAL(10, 2) NOT NULL,
    Status varchar(10) NOT NULL,
    FOREIGN KEY (OrderID) REFERENCES Orders(OrderID),
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
    ON DELETE CASCADE  -- Delete cascading
    ON UPDATE CASCADE  -- Update cascadingcompanycustomers
);

create table Quote(
QuoteID INT AUTO_INCREMENT PRIMARY KEY,
OrderId int,
CustomerId int,
EmployeeId int,
FOREIGN KEY (OrderID) REFERENCES Orders(OrderID),
FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID),
FOREIGN KEY (EmployeeId) REFERENCES Employees(EmployeeId)
)

select * from Orders;
delete from Orders;
delete from orderproducts;
select * from orderProducts;
select * from Products;
select price, quantity from Products natural join OrderProducts;
select c.Name , o.OrderId,o.ShippingCost,o.TotalOrderValue,o.status from Customers c natural join Orders o where CustomerID = 23;
Select o.OrderID,o.OrderDate,o.CustomerID,o.CustomerShippingAddress,o.TotalOrderValue,o.ShippingCost,o.ShippingAgency,o.Status from Customers c natural join Orders o where CustomerID = 23 and status='Pending';
select * from Invoices;
select * from Employees;
Select o.OrderID,o.OrderDate,o.CustomerID,o.CustomerShippingAddress,o.TotalOrderValue,o.ShippingCost,o.ShippingAgency,o.Status from Orders o  where  o.Status='Pending';
select * from Quote;
select orderId, CustomerId from Orders natural join Quote;
Select o.OrderID,o.OrderDate,o.CustomerID,o.CustomerShippingAddress,o.TotalOrderValue,o.ShippingCost,o.ShippingAgency,o.Status from Customers c natural join Orders o  where CustomerID = 23 and o.Status='Pending'
