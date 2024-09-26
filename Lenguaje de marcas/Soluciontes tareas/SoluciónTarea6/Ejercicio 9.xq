(:Ejercicio 9. Obtener el precio medio de todos los libros de tapa dura:)
let $hardcoverBooks := doc("biblioteca.xml")/library/catalog/book[edition = "hardcover"]
return
avg($hardcoverBooks/price)