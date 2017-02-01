select Brand.Brand_Name,
       count(Product.Brand_ID) count_product
  from Brand inner join Product
    on Brand.Brand_ID = Product.Brand_ID
 group by Brand.Brand_Name
 order by count_product DESC
 limit 10;