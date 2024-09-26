<?xml version="1.0" encoding="UTF-8"?>



<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

       <xsl:template match="/">
        <html>
            <head>
                <title>Practica1.xsl</title>
            </head>
            <body>
                
                
                <h2> PRÁCTICA 1 de XSL </h2>
 
               <p>El titulo de la película es <xsl:value-of select="pelicula/titulo"/> </p>
               
               <p> <xsl:value-of select="pelicula/descripcion"/> </p>
                              
                                
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
