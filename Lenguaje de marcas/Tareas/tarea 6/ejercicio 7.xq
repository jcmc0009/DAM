(: Encontrar todos los cursos impartidos por un profesor específico:)

for $b in doc ("biblioteca.xml")//courses/course
where $b/teachers/teacher='Luis del Moral'
  return concat ("El curso """,$b/title,""" es impartido por Luis del Moral")