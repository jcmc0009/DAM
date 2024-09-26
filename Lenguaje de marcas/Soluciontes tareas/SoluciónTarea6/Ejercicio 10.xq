(:Ejercicio 10. Encuentra los libros más caros de cada categoría y muestra su categoría, el título, el precio y el autor:)
 for $category in distinct-values (doc("biblioteca.xml")/library/catalog/book/@category)
 let $max_price := max(doc("biblioteca.xml")/library/catalog/book[@category=$category]/price)
 let $book_expensive := doc("biblioteca.xml")/library/catalog/book[@category=$category and price = $max_price]
 return
 <book>
   <category>{data($category)}</category>
   <title>{data($book_expensive/title)}</title>
   <price>{data($max_price)}</price>
   <author>{data($book_expensive/authors)}</author> 
 </book>