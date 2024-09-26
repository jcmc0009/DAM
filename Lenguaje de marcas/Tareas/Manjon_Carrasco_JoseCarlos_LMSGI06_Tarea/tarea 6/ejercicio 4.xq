(:Obtener información sobre los cursos impartidos en enero de 2024 con el siguiente formato(se tendrán que concatenar los campos adecuados para obtener la fecha):)
for $c in doc("biblioteca.xml")//library/courses/course
where $c/date/year = 2024 and $c/date/month = 1

return 
<course>
{$c/title}
<date>
{concat($c/date/day, "/", $c/date/month, "/", $c/date/year)} 
</date>
</course>
