<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

       <xsl:template match="/">
        <html>
            <head>
                <title>Practica13.xsl</title>
            </head>
            <body>
                <h3> PRÁCTICA 13 </h3>
                
                <table border="1">
                    <tr>
                        <th> PRECIO</th>
                        <th> TÍTULO</th>
                        <th> AÑO </th>
                    </tr>
                    <xsl:for-each select="//libro">
                       <xsl:sort select="precio" order="ascending" data-type="number" />
                        <tr>
                            <td> <xsl:value-of select="precio"/> </td>
                            <xsl:choose>
                                <xsl:when test="precio > 100">
                                    <td bgcolor="red"> 
                                        <xsl:value-of select="titulo"/> 
                                    </td>
                                </xsl:when>
                                <xsl:otherwise> 
                                    <td> 
                                    <xsl:value-of select="titulo"/></td>
                                </xsl:otherwise>
                            </xsl:choose>                                                                        
                            
                            <td> 
                               <span style="font-style:italic"> 
                                   <xsl:value-of select="@año"/> 
                               </span>
                            </td>
                        </tr>                    
                        
                    </xsl:for-each>
                    
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
