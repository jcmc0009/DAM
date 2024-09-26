(:Obtener el nombre de los autores de los libros de terror:)

distinct-values(
  for $b in doc("biblioteca.xml")//book
  where $b/@category = 'horror'
  for $c in $b/authors/author
  return concat ("Es autor de libros de terror ",$c)
)
