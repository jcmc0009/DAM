(:Obtener un listado de los libros en orden alfabético:)
for $b in doc("biblioteca.xml")//catalog/book
order by  $b/title ascending
return <libro>{$b/title}</libro>     

