(:Ejercicio 4. Obtener información sobre los cursos impartidos en enero de 2024 con el siguiente formato (se tendrán que concatenar los campos adecuados para obtener la fecha):
          <course>
                <title>Título del libro</title>
                <date>Fecha del curso (en el formato día/mes/año)</date>
          </course>
:)
<courses>
{
    for $course in doc("biblioteca.xml")/library/courses/course
    where $course/date/year = 2024 and $course/date/month = 1
    return
    <course>
        <title>{ $course/title/text() }</title>
        <date>{ concat($course/date/day, ' / ', $course/date/month, ' / ', $course/date/year) }</date>
    </course>
}
</courses>