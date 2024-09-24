<?xml version="1.0" encoding="UTF-8"?>



<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>Tarea04.xsl</title>
                <link rel="stylesheet" href="css/estilos.css"/> 
            </head>
            <body>
                <table border="1">
                    <tr>  
                        <th> Nombre del grado</th>
                        <th> Número de asignaturas </th>
                        <th> Suma total de créditos </th>
                  
                
                    </tr>  
                    <xsl:for-each select="//grado">  
                  
                        <xsl:variable name="cod_grado" select="@cod_grado"/> 
                      
                                           
                         
                                    
                        <tr>
                            <td> 
                                <xsl:value-of select="nombre"/>
                            </td>
                            <td align="center">
                                
                    
                                <xsl:value-of select="count(//asignatura[@ref=$cod_grado])"/>
          
                            </td>
                                
                                
                                
                                                             
                        
                            <td align="center">
                           
                                <xsl:variable name="total_creditos" select="sum(//asignatura[@ref=$cod_grado]/numero_creditos)" />

                                <xsl:value-of select="$total_creditos" />

           
                            </td>
                    
                        </tr>
                    </xsl:for-each>  
                      
                </table>            
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
