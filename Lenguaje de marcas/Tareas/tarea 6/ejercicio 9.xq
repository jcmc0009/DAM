(: Obtener el precio medio de todos los libros de tapa dura:)

let $precio := round(avg(doc("biblioteca.xml")//catalog/book/price),2)
 
let $c := doc("biblioteca.xml")//catalog/book
where $c/edition='hardcover'
return  concat ("El precio medio es de ", $precio ,"€")