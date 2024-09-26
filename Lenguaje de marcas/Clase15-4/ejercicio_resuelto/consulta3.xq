(: Ejemplo de uso de la cláusula FOR y LET juntas. Obtener todos los títulos de los libros del fichero libros.xml junto con los autores de cada libro :)
for $b in doc("libros.xml")//libro
    let $c := $b/autor
    return
    <libro>{ $b/titulo, <autores>{ $c }</autores>}</libro>