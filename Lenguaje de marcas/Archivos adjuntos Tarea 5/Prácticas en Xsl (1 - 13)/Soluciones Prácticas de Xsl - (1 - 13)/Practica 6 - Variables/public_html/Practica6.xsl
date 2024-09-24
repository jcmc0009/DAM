<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>
    <xsl:template match="/">
        <html>
             <body>
                 <h3> PRÁCTICA 6 - USO DE VARIABLES POR PRIMERA VEZ </h3>
                 
                 <xsl:variable name="mensaje" >Hola mundo.</xsl:variable>
                
                 <xsl:value-of select="$mensaje" />
            
                 
                 <xsl:variable name="nombre_cole" select="colegio/nombre" />
                 
                 
                <p> <xsl:value-of select="$nombre_cole"/> </p>
                                  
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
