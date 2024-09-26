<?xml version="1.0" encoding="UTF-8"?>


<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="xml"/>

  
    <xsl:template match="/">
        <html>
            <body>
                  <h3> PRÁCTICA 5 de Xsl</h3>
                  
                  <h2> Mi colección de CD´s</h2>
                  
                  <xsl:for-each select="//cd">
                      
                      <p> Título: <span style="color:red"> <xsl:value-of select="titulo"/> </span> </p>
                      
                      <p> Artista: <span style="color:green"> <xsl:value-of select="artista"/> </span> </p>
                      
                  </xsl:for-each>
            </body>
        </html>
    </xsl:template>
    
  
  

</xsl:stylesheet>
