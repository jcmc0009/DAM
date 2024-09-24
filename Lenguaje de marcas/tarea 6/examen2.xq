(:Obtener las calificaciones del alumno/a que su código contiene "345", en cada uno de los módulos que
ha sacado Sobresaliente o Matrícula de honor. Indicar el nombre del módulo:)
for $clase in doc ("examen.xml")//clase
let $alumnos :=doc( "examen.xml")//alumnos/alumno/apenom
let $calificacion :=doc( "examen.xml")//notas/nota
let $modulo :=doc( "examen.xml")//asignaturas/asignatura
for $b in doc ("examen.xml")//notas//nota
let $asignatura :=doc( "examen.xml")//asignaturas/asignatura
let $nota :=doc( "examen.xml")//notas/nota
let $alumnos :=doc( "examen.xml")//alumnos/alumno/apenom
where 
$b[contains (@alum,'345')]
and $b/@calificacion>=9
 
  return
 
  <calificaciones> {$b,$alumnos}
  </calificaciones> 