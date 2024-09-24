<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>
    <xsl:template match="/">
        <html>
            <head>
                <title>Practica11.xsl</title>
            </head>
            <body>
                <h3> PRÁCTICA 11 </h3>
                
                <ol>
                    <xsl:for-each select="//autor">
                        <xsl:sort select="apellido" order="ascending"/>
                      
                            <li> <xsl:value-of select="apellido"/> , <xsl:value-of select="nombre"/></li>
                            
                     
                    </xsl:for-each>
                </ol>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
