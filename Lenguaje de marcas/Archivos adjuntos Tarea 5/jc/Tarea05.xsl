<?xml version="1.0" encoding="UTF-8" standalone="yes"?>


<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <xsl:template match="/">
       
        <html>
            <head>
                <title>Tarea05.xsl</title>
                <link rel="stylesheet" href="css/estilos.css"/> 
            </head>
            <body>
         
             
                <xsl:for-each select="//grado">  
                  
                    <xsl:variable name="cod_grado" select="@cod_grado"/> 
                    <xsl:variable name="nombre_grado" select="nombre"/>
                    <xsl:variable name="numero_creditos" select=" numero_creditos"/> 
                    <xsl:variable name="numero_cursos" select=" numero_cursos"/>
                </xsl:for-each>    
                <xsl:for-each select="//asignatura">  
               
                    <xsl:variable name="nombre_profesor" select="nombre_profesor"/> 
                    <xsl:variable name="codigo_profesor" select="@cod_profesor"/>
                    <xsl:variable name="codigo_asignatura" select="@cod_asignatura"/>
                    <xsl:variable name="nombre_asignatura" select="nombre"/>
                    <xsl:variable name="numero_creditos" select="numero_creditos"/>
               
                    <table>
                        <tr>
                            <th>
                                        
                                <p>Asignatura <xsl:value-of  select="$nombre_asignatura"/> 
                                </p>
                                <p>
                                    <ol> 
                                        <h5> 
                                            <u>ALUMNOS MATRICULADOS: </u> 
                                        </h5>
                                        <xsl:for-each select="//alumno[@ref=$codigo_asignatura]">
                            
                                            <li>  
                                                <xsl:value-of select="nombre"/> 
                                            </li>
                                        </xsl:for-each>
                                    </ol> 
                                </p>
                              
                                
                                
                                <!--   <p>Los alumnos matriculados son:  <xsl:value-of select="$codigo_asignatura"/> /</p>                                        
                                <xsl:for-each select="//alumno[@ref=$codigo_asignatura]">
                            
                                    <li>  
                                        <xsl:value-of select="nombre"/> 
                                    </li>
                                </xsl:for-each> -->
                                <p>Número de créditos <xsl:value-of select="$numero_creditos" /></p>
                                <p>Nómbre del profesor <xsl:value-of select="$nombre_profesor"/> </p>
                              
                            </th>       
                          
                               
                        </tr>  
                                     
                    </table>
                                                                               
          
                </xsl:for-each> 
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
   