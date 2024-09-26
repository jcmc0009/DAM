(:Ejercicio 5. Obtener un listado de los libros en orden alfabético:)
for $book in doc("biblioteca.xml")/library/catalog/book
order by $book/title
return $book/title