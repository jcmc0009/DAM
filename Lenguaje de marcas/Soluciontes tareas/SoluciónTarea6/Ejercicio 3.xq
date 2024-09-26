(:Ejercicio 3. Obtener el nombre de los autores de los libros de terror:)
distinct-values(doc("biblioteca.xml")/library/catalog/book[@category = "horror"]/authors/author)