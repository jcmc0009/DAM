(:Obtener un listado de los libros en orden alfabético:)
let $c := max(doc("biblioteca.xml")//catalog/book/price)
return concat ("El precio del libro mas alto es de ",$c,"€")
    

