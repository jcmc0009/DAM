(: Encuentra los libros mas caros de cada categoría y muestra su categoría, el título, el precio y el autor :)
(:Buscamos en los nódulos book  el atributo category , pero no repetimos los atributos:)
for $categoria in distinct-values(doc("biblioteca.xml")//book/@category)

 (:Declaramos la variable precio máximo en la ruta /book/price para aquellos nódulos book:)
let $precioMaximo := max(doc("biblioteca.xml")//book[@category=$categoria]/price)
return
  <libro>
    <categoria>{$categoria}</categoria>
    {
    for $b in doc("biblioteca.xml")//book
where $b/@category = $categoria and $b/price = $precioMaximo
return $b}
</libro>
