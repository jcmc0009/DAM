(:Ejercicio 7. Encontrar todos los cursos impartidos por un profesor específico:)

for $b in doc("biblioteca.xml")//course
where $b/teachers/teacher = "Antonio Calvo"
return $b/title