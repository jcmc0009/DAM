<?xml version="1.0" encoding="UTF-8"?>



<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>Tarea03.xsl</title>
                <link rel="stylesheet" href="css/estilos.css"/> 
            </head>
            <body>
                <table  border="1" >
                  
                    <tr>  
                     
             
                        <th> Asignaturas informática</th>
                        <th> Nombre del grado </th>
                        <th> Turno </th>
                        <th> Número créditos de la asignatura </th>
                        <th> Número de alumnos matriculados </th>
                                
                
                    </tr> 
                
                    <xsl:for-each select="//asignatura[@ref='GPSI' or @ref='GINF']">
                  
                        <xsl:variable name="id_grado" select="@ref"/> 
                      
                        <xsl:variable name="id_asignatura" select="@cod_asignatura"/>      
                      
                         
                                    
                        <tr>
                            <td> 
                                <xsl:value-of select="nombre"/>
                            </td>
                            <td>
                                <xsl:for-each select="//grado[@cod_grado=$id_grado]">
                                   
                                    <xsl:value-of select="nombre"/>
                                 
                                </xsl:for-each>
                            </td>
                            <xsl:choose>
                                <xsl:when test="@turno='tarde'">
                                    <td>
                                        <xsl:attribute name="style">background-color: orange;</xsl:attribute>

                                        <xsl:value-of select="@turno"/>
                                       
                                    </td>
                                </xsl:when>
                                   
                                <xsl:otherwise>
                                    <td>
                                        <xsl:attribute name="style">background-color: green;</xsl:attribute>

                                        <xsl:value-of select="@turno"/>
                                       
                                    </td> 
                                </xsl:otherwise>                      
                               
                            </xsl:choose> 
                                
                            <xsl:choose>
                                <xsl:when test="numero_creditos &lt; 5">
                                    <td align="center">
                                        <span style="color:red">
                                            <xsl:value-of select="numero_creditos"/>
                                        </span> 
                                    </td>
                                </xsl:when>
                                <xsl:when test="numero_creditos &gt; 5 and numero_creditos &lt; 10">
                                    <td align="center">
                                        <span style="color:green">
                                            <xsl:value-of select="numero_creditos"/>
                                        </span> 
                                    </td>
                                </xsl:when>    
                                <xsl:otherwise>
                                    <td align="center">
                                        <span style="color:blue">
                                            <xsl:value-of select="numero_creditos"/>
                                        </span>
                                    </td>
                                </xsl:otherwise>                             
                               
                            </xsl:choose>  
                            <td align="center" >
               
                                   
                                <xsl:value-of select="count (//alumno[@ref=$id_asignatura])"/>
                                 
                
                            </td>
                        </tr>
                    </xsl:for-each>  
                      
                </table>            
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
