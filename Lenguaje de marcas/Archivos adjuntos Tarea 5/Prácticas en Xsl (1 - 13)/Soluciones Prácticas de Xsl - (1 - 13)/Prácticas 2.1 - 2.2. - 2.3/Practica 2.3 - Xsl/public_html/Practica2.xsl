<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet  version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" >
    
<xsl:output method="html"/>

<xsl:template match="/">

<html>
    <head></head>
<body>
    
  <h3> PRÁCTICA 2.3 - XSL </h3>
  
  <xsl:for-each select="//gasto">
    
    <xsl:choose>
         <xsl:when test="@desgravable='si'">
            <p>  <xsl:value-of select="concepto"/> </p>
         </xsl:when>
         
         <xsl:otherwise>
            <p>  <xsl:value-of select="importe"/> </p>
         </xsl:otherwise>
         
    </xsl:choose>
</xsl:for-each>   
   
     
</body>          
</html>   
</xsl:template>  
    
</xsl:stylesheet>


 
