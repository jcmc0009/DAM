(: Ejemplo de uso de la cláusula FOR. Obtener todos los títulos de los libros del fichero libros.xml :)
for $d in doc("libros.xml")/biblioteca/libros/libro/titulo
  return <titulos>{ $d }</titulos>
