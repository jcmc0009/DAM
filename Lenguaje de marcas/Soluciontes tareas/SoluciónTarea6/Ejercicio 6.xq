(:Ejercicio 6. Encontrar el libro más caro del catálogo :)

let $precioMaximo := max(doc("biblioteca.xml")//catalog/book/price)
for $b in doc("biblioteca.xml")//catalog/book
where $b/price = $precioMaximo
return $b/title