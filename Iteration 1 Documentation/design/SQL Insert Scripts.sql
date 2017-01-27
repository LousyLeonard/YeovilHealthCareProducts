USE YeovilHealthcare;

INSERT INTO Brand(Brand_ID, Brand_Name) VALUES (1, "Pampers");
INSERT INTO Brand(Brand_ID, Brand_Name) VALUES (2, "Nicorette");
INSERT INTO Brand(Brand_ID, Brand_Name) VALUES (3, "Oral B");

INSERT INTO Product(Product_ID, Product_Name, Product_Price, Brand_ID) VALUES (1, "Ultra Sensitive Nappies", 6.00, 1);
INSERT INTO Product(Product_ID, Product_Name, Product_Price, Brand_ID) VALUES (2, "Original Flavour Sugar Free Gum", 10.00, 2);
INSERT INTO Product(Product_ID, Product_Name, Product_Price, Brand_ID) VALUES (3, "Electric Toothbrush", 49.99, 3);

INSERT INTO Image (Image_ID, Image_Filepath, Product_ID) VALUES (1, "images/products/Pampers.jpg", 1);
INSERT INTO Image (Image_ID, Image_Filepath, Product_ID) VALUES (2, "images/products/Nicorette.jpg", 2);
INSERT INTO Image (Image_ID, Image_Filepath, Product_ID) VALUES (3, "images/products/OralB.jpg", 3);

INSERT INTO Keyword (Keyword_ID, Keyword_Text) VALUES (1, "Baby");
INSERT INTO Keyword (Keyword_ID, Keyword_Text) VALUES (2, "Care");
INSERT INTO Keyword (Keyword_ID, Keyword_Text) VALUES (3, "Smoking");
INSERT INTO Keyword (Keyword_ID, Keyword_Text) VALUES (4, "Edible");
INSERT INTO Keyword (Keyword_ID, Keyword_Text) VALUES (5, "Electric");
INSERT INTO Keyword (Keyword_ID, Keyword_Text) VALUES (6, "Dental");

INSERT INTO Product_Keyword (Product_ID, Keyword_ID) VALUES (1, 1);
INSERT INTO Product_Keyword (Product_ID, Keyword_ID) VALUES (1, 2);
INSERT INTO Product_Keyword (Product_ID, Keyword_ID) VALUES (2, 3);
INSERT INTO Product_Keyword (Product_ID, Keyword_ID) VALUES (2, 4);
INSERT INTO Product_Keyword (Product_ID, Keyword_ID) VALUES (3, 5);
INSERT INTO Product_Keyword (Product_ID, Keyword_ID) VALUES (3, 6);