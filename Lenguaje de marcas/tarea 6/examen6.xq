(:Obtener el nombre del alumno/a y el módulo en el que ha obtenido la calificación más baja.:)
let $minCalif := min(doc("examen.xml")//nota/@calificacion)
let $alumno := doc("examen.xml")//nota[@calificacion = $minCalif]/@alum
let $modulo := doc("examen.xml")//nota[@calificacion = $minCalif]/@asig
for $alumnoNotaMinima in doc("examen.xml")//alumno
let $asignatura := doc("examen.xml")//asignatura[@cod = $modulo]/@nombre

where $alumnoNotaMinima[@cod=$alumno]
return 

<alumno>{$alumnoNotaMinima/apenom}, 
<modulo>
<nombre>
{$asignatura/data()}</nombre>
<calificacion>{$minCalif}
</calificacion>
</modulo>
</alumno>
