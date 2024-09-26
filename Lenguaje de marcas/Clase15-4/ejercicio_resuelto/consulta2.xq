(: Ejemplo de uso de la cláusula LET. Obtener todos los títulos de los libros del fichero libros.xml :)
let $d := doc("libros.xml")/biblioteca/libros/libro/titulo
  return
  <titulos>{ $d }</titulos>