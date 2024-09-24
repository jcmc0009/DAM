<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="/">
        <html>
            <head>
                <title>Practica 12.xsl</title>
            </head>
            <body>
                <h3> PRÁCTICA 12 </h3>
                
                <ol>
                    <xsl:for-each select="//libro">
                       
                        <xsl:if test="precio &lt; 100">
                        
                            <li> <xsl:value-of select="titulo"/> </li>
                            
                        </xsl:if>  
                        
                        
                    </xsl:for-each>
                </ol>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
