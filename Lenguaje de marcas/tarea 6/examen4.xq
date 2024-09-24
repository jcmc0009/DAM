(:Obtener el nombre, teléfono y dirección del alumnado que vive en la provincia de Granada, salvo en
Guadix, ordenado por apellidos. Sigue el formato del resultado.:)
for $clase in doc ("examen.xml")//alumno

where $clase/prov='Granada'
and $clase/pobla!='Guadix'

return <alumno>{concat("El/la alumno/a """, $clase/apenom),"tiene el teléfono" ,$clase/telef/data()," y vive en ",$clase/direc/data()}
</alumno>


