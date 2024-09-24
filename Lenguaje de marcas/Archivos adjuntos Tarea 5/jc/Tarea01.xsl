<?xml version="1.0" encoding="UTF-8"?>



<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>Tarea01.xsl</title>
            </head>
            <body>
                
                
                <h2> Tarea 01 de XSL </h2>
                <ol> <!--Creamos una lista ordenada-->
                    <xsl:for-each select="//grado"><!--Accedemos a todos los elementos grado-->
                        <xsl:sort order="ascending" data-type="number" select="numero_creditos"/> <!--Definimos porqué queremos ordenar-->
                        <li>   <!--Creamos una lista en el que  seleccionamos qué queremos mostrar y lo seleccionamos-->
                            <p>El nombre del grado : <xsl:value-of select="//nombre"/> -- <xsl:value-of select="numero_creditos"/> créditos.--<xsl:value-of select="numero_cursos"/>--cursos--NOTA CORTE: (<xsl:value-of select="nota_corte"/>)--<xsl:value-of select="numero_plazas"/> plazas--Número de asignaturas: ##<xsl:value-of select="numero_asignaturas"/>##</p>
                        </li>
                    </xsl:for-each>

                </ol>
                                        
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
