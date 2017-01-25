
SELECT 
	p.Product_Name,
	b.Brand_Name,
	p.Product_Price,
	i.Image_Filepath
FROM YeovilHealthcare.Product AS p

INNER JOIN Brand AS b
	ON b.Brand_ID = p.Brand_ID
INNER JOIN Image AS i
	ON i.Product_ID = p.Product_ID;




SELECT 
	p.Product_Name,
	b.Brand_Name,
	p.Product_Price,
	i.Image_Filepath
FROM YeovilHealthcare.Product AS p

INNER JOIN Brand AS b
	ON b.Brand_ID = p.Brand_ID
INNER JOIN Image AS i
	ON i.Product_ID = p.Product_ID

WHERE b.Brand_Name = searchFieldEntry;





SELECT 
	p.Product_Name,
	b.Brand_Name,
	p.Product_Price,
	i.Image_Filepath
FROM YeovilHealthcare.Product AS p

INNER JOIN Brand AS b
	ON b.Brand_ID = p.Brand_ID
INNER JOIN Image AS i
	ON i.Product_ID = p.Product_ID
LEFT JOIN Product_Keyword AS pk
	ON pk.Product_ID = p.Product_ID
LEFT JOIN Keyword AS k
	ON k.Keyword_ID = pk.Keyword_ID;

WHERE p.Product_Name = searchFieldEntry 
	OR b.Brand_Name = searchFieldEntry
	OR k.Keyword_Text = searchFieldEntry;
	
	
	
	
	
	
