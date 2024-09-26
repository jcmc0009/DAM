(: Obtener todos los títulos de los libros del fichero libros.xml junto con los autores de cada libro. Usando solo la cláusula for:)
for $b in doc("libros.xml")//libro
  return <libro>{ $b/titulo, <autores>{$b/autor}</autores>}</libro>