CREATE DATABASE IF NOT EXISTS YeovilHealthcare DEFAULT CHARACTER SET utf8;
USE YeovilHealthcare;

CREATE TABLE IF NOT EXISTS YeovilHealthcare.Brand (
Brand_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
Brand_Name CHAR(100)
);

CREATE TABLE IF NOT EXISTS YeovilHealthcare.Product (
Product_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
Product_Name CHAR(255),
Product_Price DECIMAL(10,2),
Brand_ID INT,
FOREIGN KEY(Brand_ID) REFERENCES Brand(Brand_ID)
);

CREATE TABLE IF NOT EXISTS YeovilHealthcare.Image (
Image_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
Image_Filepath CHAR(255),
Product_ID INT,
FOREIGN KEY(Product_ID) REFERENCES Product(Product_ID)
);

CREATE TABLE IF NOT EXISTS YeovilHealthcare.Keyword (
Keyword_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
Keyword_Text CHAR(100)
);

CREATE TABLE IF NOT EXISTS YeovilHealthcare.Product_Keyword (
Product_ID INT,
Keyword_ID INT,
PRIMARY KEY(Product_ID, Keyword_ID),
FOREIGN KEY (Product_ID) REFERENCES Product(Product_ID),
FOREIGN KEY (Keyword_ID) REFERENCES Keyword(Keyword_ID)
);