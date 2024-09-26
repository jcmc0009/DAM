(:Ejercicio 2. Encontrar todos los libros publicados después de 2010. Deberás mostrar la información de la siguiente forma:

          <book>
                <title>Título del libro</title>
                <year>Año de publicación</year>
          </book>:)

<books>
{
    for $book in doc("biblioteca.xml")/library/catalog/book
    where $book/year > 2010
    return
    <book>
        <title>{ $book/title/text() }</title>
        <year>{ $book/year/text() }</year>
    </book>
}
</books>