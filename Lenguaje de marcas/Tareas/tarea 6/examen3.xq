(:Obtener el nombre del alumnado que sea de Madrid. Indicar la dirección completa:)
for $clase in doc ("examen.xml")//alumno

where $clase/prov='Madrid'

return
<alumno>
{$clase/apenom,$clase/direc,$clase/pobla}
</alumno> 