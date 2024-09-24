(: Obtener el nombre de alumnos matriculados en algún modulo:)
for $b in doc ("examen.xml")//alumno/apenom
  return $b