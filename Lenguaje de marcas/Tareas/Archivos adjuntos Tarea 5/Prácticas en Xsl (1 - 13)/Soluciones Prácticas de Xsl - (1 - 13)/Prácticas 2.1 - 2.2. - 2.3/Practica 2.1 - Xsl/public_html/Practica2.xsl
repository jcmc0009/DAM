<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet  version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" >
    
<xsl:output method="html"/>

<xsl:template match="/">

<html>
    <head></head>
<body>
    
  <h3> PRÁCTICA 2.1 - XSL </h3>
  
     <xsl:for-each select="//gasto/concepto">
      
       <p> <xsl:value-of select="."/> </p> 
     
  </xsl:for-each>
 
   
     
</body>          
</html>   
</xsl:template>  
    
</xsl:stylesheet>


 

   
      
     <!--2
<xsl:for-each select="//gasto">
    
   <xsl:if test="@desgravable='si'">
       
        <p> <xsl:value-of select="concepto"/> </p>
        
   </xsl:if> 
          
</xsl:for-each> -->
 
