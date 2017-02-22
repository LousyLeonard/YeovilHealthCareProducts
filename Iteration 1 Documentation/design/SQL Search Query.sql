SELECT p.Product_Name, b.Brand_Name, p.Product_Price
FROM YeovilHealthcare.Product AS p 
INNER JOIN Brand AS b 
ON b.Brand_ID = p.Brand_ID 
INNER JOIN product_keyword AS pk
ON p.Product_ID = pk.Product_ID
INNER JOIN keyword AS k
ON pk.Keyword_ID = k.Keyword_ID
WHERE p.Product_Name IN("sapien", "a")
OR b.Brand_Name IN("sapien", "a") 
OR k.Keyword_Text IN("sapien", "a")
LIMIT 50 OFFSET 1;
