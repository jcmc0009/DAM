(:Ejercicio 8. Obtener el nombre de todos los libros, junto con el autor y el género, ordenados alfabéticamente por género:)
for $book in doc ("biblioteca.xml")/library/catalog/book
order by @category
return
  <book>
    <category>{data($book/@category)}</category>
    <title>{data($book/title)}</title>
    <author>{data($book/authors)}</author>
  </book>