<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

   
  <xsl:template match = "/"> 
 <html> 
 <body> 
      <h3> PRÁCTICA 8 de Xsl</h3>
      <h2>Estudiantes</h2> 
      
     <table border = "1"> 
        <tr bgcolor = "#9acd32"> 
            <th>No Matrícula</th> 
            <th>Nombre</th> 
            <th>Apellido</th> 
            <th>Nick</th> 
            <th>Calificación</th> 
            <th>Grado</th> 
        </tr> 
        
        <xsl:for-each select = "estudiantes/estudiante"> 
            <tr> 
                <td><xsl:value-of select = "@nunmatri"/></td> 
                <td><xsl:value-of select = "nombre"/></td> 
                <td><xsl:value-of select = "apellido"/></td> 
                <td><xsl:value-of select = "nick"/></td> 
                <td><xsl:value-of select = "calificacion"/></td> 
                <td> 
                    <xsl:choose> 
                         <xsl:when test = "calificacion > 9.0"> Nivel Alto</xsl:when> 
                         
                         <xsl:when test = "calificacion > 8.5"> Nivel Medio</xsl:when>
                          
                        <xsl:otherwise>Nivel Bajo</xsl:otherwise> 
                        
                    </xsl:choose> 
                </td> 
            </tr> 
        </xsl:for-each> 
     </table> 
 </body> 
 </html> 
 </xsl:template> 
</xsl:stylesheet>
  