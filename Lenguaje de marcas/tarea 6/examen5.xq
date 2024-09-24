(:Obtener los nombres del alumnado suspenso en LMSGI y aprobado en GBD, así como sus notas,
ordenados desde la nota más alta a la más baja
:)

let $codlmsgi := doc("examen.xml")//asignatura[@nombre='LMSGI']/@cod
let $codgbd := doc("examen.xml")//asignatura[@nombre='GBD']/@cod
let $nombreAsignatura :=doc("examen.xml")//asignatura
for $n in doc ("examen.xml")//nota
order by  $n/@calificacion descending

where ($n/@asig=$codlmsgi and $n/@calificacion<5) or ($n/@asig=$codgbd and $n/@calificacion>=5) 

  let $alumno := doc("examen.xml")//alumno[@cod=$n/@alum] 
return
<alumno>{$alumno/apenom},
<asignatura>{$nombreAsignatura[@cod=$n/@asig]/@nombre/data()}
</asignatura>,
<calificacion>{$n/@calificacion/data()}
</calificacion>
</alumno>
