(:Ejemplo de uso de las cláusulas WHERE y ORDER BY en una consulta con dos ficheros. Obtiene los títulos de los libros prestados con sus autores y la fecha de inicio y devolución del préstamo, ordenados por la fecha de inicio del préstamo :)
for $t in doc("libros.xml")//libro, $e in doc("prestamos.xml")//entrada
  where $t/titulo = $e/titulo
  order by $e/prestamo/inicio
  return <prestamo>{ $t/titulo, $t/autor/*, $e/prestamo/inicio, $e/prestamo/devolucion }</prestamo>