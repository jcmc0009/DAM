<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet  version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" >
    
<xsl:output method="html"/>

<xsl:template match="/">

<html>
    <head></head>
<body>
    
  <h3> PRÁCTICA 2.2 - XSL </h3>
  
      <p>El material que es desgravable es: </p>
  <xsl:for-each select="//gasto">
     
      <xsl:if test="@desgravable='si'">
    
       <li>
  <xsl:value-of select="concepto"/> 
       </li>
     </xsl:if> 
          
 </xsl:for-each>
   
     
</body>          
</html>   
</xsl:template>  
    
</xsl:stylesheet>


      
 
 
