<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>
    
    <xsl:template match="/">
        <html>
            <head>
                <title>Practica10.xsl</title>
            </head>
            <body>
                <h3> PRÁCTICA 10 </h3>
                
               <h1> <xsl:value-of select="ies/@nombre"/> </h1>
                              <!-- IMPORTANTE: PARA QUE APAREZCA EL ATRIBUTO, TENEMOS QUE PONER EL NOMBRE DEL ELEMENTO
                                              DONDE SE ENCUENTRA EL ATRIBUTO -->
               
                         
                     <table border="1"> 
                    <tr>
                        <th> NOMBRE DEL CICLO </th>
                        <th> AÑO </th>
                    </tr>
                    
                    <xsl:for-each select="//ciclo">
                       <tr>
                           <td><xsl:value-of select="nombre"/></td>
                           
                           <xsl:choose>
                               <xsl:when test="decretoTitulo/@año &gt; 2009">
                                   <td>
                                        <span style="color:green">
                                           <xsl:value-of select="decretoTitulo/@año"/>
                                        </span> 
                                   </td>
                               </xsl:when>
                               <xsl:when test="decretoTitulo/@año &lt; 2009">
                                   <td>
                                       <span style="color:red">
                                           <xsl:value-of select ="decretoTitulo/@año"/>
                                       </span>
                                   </td>
                               </xsl:when>
                               <xsl:otherwise>
                                   <td>
                                       <span style="color:blue">
                                           <xsl:value-of select="decretoTitulo/@año"/>
                                       </span>
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


