<?xml version="1.0" encoding="UTF-8"?>



<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>Tarea02.xsl</title>
            </head>
            <body>
                
                <h2> Tarea 02 de XSL </h2>

                <xsl:for-each select="//grados">
                    <xsl:variable name="totalGrados" select="count(//grado)" />
         
                         
                    <p>Número total de grados: <xsl:value-of select="$totalGrados" /></p>
                 
                </xsl:for-each>
               
                <xsl:for-each select="//asignaturas">
                    <xsl:variable name="totalAsignaturas" select="count(//asignatura)"/>
                    
                                   
                    <p>Número total de asignaturas: <xsl:value-of select="$totalAsignaturas" /></p>
                </xsl:for-each>
                <xsl:for-each select="//alumnos">
                    <xsl:variable name="totalAlumnos" select="count(//alumno)"/>
                    
                                   
                    <p>Número total de alumnos <xsl:value-of select="$totalAlumnos" /></p>
                </xsl:for-each>

                <p>Número total de plazas existentes: <xsl:value-of  select="sum(//grado/numero_plazas)"/> </p>
                
                <p>Nota media de corte de los 3 grados: <xsl:value-of select="format-number( sum(//grado/nota_corte) div count (//grado/nota_corte), '##.##')"/> </p>
              

                <!--<xsl:for-each  select="//grados">
                    <xsl:variable name="totalPlazas" select="sum(//numero_plazas)"/>
                    <xsl:variable name="mediaNotaCorte" select="sum(//nota_corte) div count (//nota_corte)"/>
                    <p>Número total de plazas existentess: <xsl:value-of select="$totalPlazas" /> </p>
                    <p>Nota media de corte de los 3 grados: <xsl:value-of select="format-number($mediaNotaCorte, '##.##')"/> </p>
                </xsl:for-each>
                -->              
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
