<?xml version="1.0" encoding="UTF-8"?>


<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

     <xsl:template match="/">
        <html>
            <body> 
                <h3> PRÁCTICA 7 - USO DE VARIABLE </h3>
                
                 <table border="1">
                    <tr>
                        <th>Nombre</th>
                        <th>Nota global</th>
                    </tr>
                    <xsl:for-each select="//alumno">
                        
                        <xsl:variable name="media" select="sum(nota) div count(nota)"/>

                        <tr>
                            <td><xsl:value-of select="nombre"/></td>
                            <td><xsl:value-of select="format-number($media, '##.##')"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
                
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
