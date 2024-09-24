(:Encontrar todos los libros publicados después de 2010:)
  for $b in doc ("biblioteca.xml")//library/catalog/book
  where $b/year > 2010
return
       <book>
            {$b/title,$b/year}
       </book>
