(: Obtener el nombre de todos los libros, junto con el autor y el género, ordenados alfabéticamente por género:)
for $b in doc("biblioteca.xml")//book
let $cb := $b/@category
order by $cb
return  
    <libro>  
        { 
            $b/title,
            $b/authors,
            <genre>{concat("",$cb)}</genre>
        }
    </libro>




