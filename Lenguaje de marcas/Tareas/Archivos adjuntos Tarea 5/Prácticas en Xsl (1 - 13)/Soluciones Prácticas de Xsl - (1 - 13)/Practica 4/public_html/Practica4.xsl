<?xml version="1.0" encoding="UTF-8"?>


<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="xml"/>

  
    <xsl:template match="/">
        <html>
            <body>
                  <h3> PRÁCTICA 4 de Xsl</h3>
                  
                  <h2> Mi colección de CD´s</h2>
                  
                  <table border="1">
                      <tr bgcolor="blue">
                          <th> Título </th>
                          <th> Artista</th>
                      </tr>
                      
                                                      
                   <xsl:for-each select="catalogo/cd">
                        <xsl:sort select="titulo"/>
                       <tr>
                          <td><xsl:value-of select="titulo"/></td>
                          
                          <xsl:choose>
                              <xsl:when test="precio &gt; 8">
                                  <td bgcolor="blue"> 
                                      <xsl:value-of select="artista"/>
                                  </td>
                              </xsl:when>
                              <xsl:otherwise>
                                  <td bgcolor="yellow"> 
                                      <xsl:value-of select="artista"/>
                                  </td>
                              </xsl:otherwise>
                          </xsl:choose>
                     </tr>
                   </xsl:for-each>
               
                </table>
                      
 
                
                
                
                
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
