(: Obtener el nombre de la biblioteca:)
for $b in doc ("biblioteca.xml")/library/data
  return concat ("El nombre de la biblioteca es """,$b/name,"""")