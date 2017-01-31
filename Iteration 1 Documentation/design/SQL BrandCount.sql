select Brand.Brand_Name brand,
       count(Product.Brand_ID) count_product
  from Brand inner join Product
    on Brand.Brand_ID = Product.Brand_ID
 group by brand
 order by count_product DESC
 limit 10;