<?xml version="1.0" encoding="UTF-8"?>


<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="/">
        <html>
       
        <body>
            <h3> PRÁCTICA 9- B </h3>
          <ol>  
            <xsl:for-each select="//ciclo">
            
               <li>  <xsl:value-of select="nombre"/>, ( <xsl:value-of select="grado"/>) </li>
                
            </xsl:for-each>
         </ol>    
            
            
      
            
            
            
        </body>            
        </html>
    </xsl:template> 
  </xsl:stylesheet>
