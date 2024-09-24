<?xml version="1.0" encoding="UTF-8"?>



<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <xsl:template match="/">          
        <html>
            <header>
                <img src="img/logo.png"/>
                <h1> INFORMACIÓN DE LA UNIVERSIDAD</h1> 
                <h3> Datos de la Universidad</h3>
            </header>
            <head>
                <title>Taread de XSL</title>
                <link rel="stylesheet" href="css/estilos.css"/> 
            </head>
            <body>
           
                <div class="apartado1">
                
                    <h3> 1. Crear una lista ordenada por el número de  créditos de menor a mayor, de
                        todos los grados, con toda su información. </h3>
                    <ol> <!--Creamos una lista ordenada-->
                        <xsl:for-each select="//grado"><!--Accedemos a todos los elementos grado-->
                            <xsl:sort order="ascending" data-type="number" select="numero_creditos"/> <!--Definimos porqué queremos ordenar, 
en este caso ascendente en base a número de créditos-->
                            <li>   <!--Creamos una lista en el que  seleccionamos qué queremos mostrar y lo seleccionamos-->
                                <p>El nombre del grado : <xsl:value-of select="//nombre"/> -- <xsl:value-of select="numero_creditos"/> créditos.--<xsl:value-of select="numero_cursos"/>--cursos--NOTA CORTE: (<xsl:value-of select="nota_corte"/>)--<xsl:value-of select="numero_plazas"/> plazas--Número de asignaturas: ##<xsl:value-of select="numero_asignaturas"/>##</p>
                            </li>
                        </xsl:for-each>

                    </ol>
                                        
                </div>
                <div class="apartado2"> 
                    <h3>  2. Mostrar el número total de grados que existen en la Universidad de Córdoba, al igual que 
                        mostrar el núméro total de asignaturas, así cómo el número total de alumnos matriculados en la Universidad de Córdoba.
                        Además, tenéis que mostrar el número total de plazas existentes en la Universidad de Córdoba y
                        la nota media de corte de los tres grados. Reflejar el resultado, acompañado del texto correspodiente
                        a su información: Ejemplo: NÚMERO TOTAL DE GRADOS: 3.  </h3>
                    <xsl:for-each select="//grados"><!--Para hacer la sumatoria de los grados , debemos recorrer el elemento grados
y hacer la cuenta de cuantos elemntos grado hay, lo guardamos en una variable y lo mostramos mas tarde, se podría hacer diréctamente
pero de este modo podemos reusar código más adelante si fuera necesario-->
                        <xsl:variable name="totalGrados" select="count(//grado)" />
                        <p>Número total de grados: <xsl:value-of select="$totalGrados" /></p>
                    </xsl:for-each>
               
                    <xsl:for-each select="//asignaturas"><!--Para hacer la sumatoria de los asignaturas , debemos recorrer el elemento asignaturas
y hacer la cuenta de cuantos elemntos asignatura hay, lo guardamos en una variable y lo mostramos mas tarde, se podría hacer diréctamente
pero de este modo podemos reusar código más adelante si fuera necesario-->
                        <xsl:variable name="totalAsignaturas" select="count(//asignatura)"/>
                        <p>Número total de asignaturas: <xsl:value-of select="$totalAsignaturas" /></p>
                    </xsl:for-each>
                    <xsl:for-each select="//alumnos"><!--Para hacer la sumatoria de los alumnos , debemos recorrer el elemento alumnos
y hacer la cuenta de cuantos elementos alumnohay, lo guardamos en una variable y lo mostramos mas tarde, se podría hacer diréctamente
pero de este modo podemos reusar código más adelante si fuera necesario-->
                        <xsl:variable name="totalAlumnos" select="count(//alumno)"/>
                                                       
                        <p>Número total de alumnos <xsl:value-of select="$totalAlumnos" /></p>
                    </xsl:for-each>
                    <!--Para conocer la sumatoria de plazas recorremos todos los elementos grado , 
                    accedemos al número de plazas y hacemos la sumatoria -->
                    <p>Número total de plazas existentes: <xsl:value-of  select="sum(//grado/numero_plazas)"/></p>
                    <!--Para calcular la media , primero debemos hacer la sumatoria de las notas de corte  y contamos cuantos notas de corte,
                    de ahí deducimos el número de asignaturas sin necesidad de añadir otro bucle para contarlas-->
                    <p>Nota media de corte de los 3 grados: <xsl:value-of select="format-number( sum(//grado/nota_corte) div count (//grado/nota_corte), '##.##')"/> </p>
              
                </div>      
                
                <div class="apartado3">
                    <h3>  3. Generar una tabla en .html, donde se muestre el nombre de todas las asignaturas del Grado 
                        de Informática y de Psicología. Además, se debe mostrar el nombre del grado al que pertenece cada asignatura. 
                        Seguidamente se mostrará, si la asignatura se imparte por la tarde o por la mañana, así como, el correspondiente
                        número de créditos de esa asignatura. En la última columna, se mostrará el número de alumnos, matriculados
                        en cada asignatura. 
                    </h3>
                    <table  border="1" ><!--Creamos la tabla-->
                  
                        <tr>  <!--Creamos el número de filas-->
                                  
                            <th> Asignaturas informática</th>
                            <th> Nombre del grado </th>
                            <th> Turno </th>
                            <th> Número créditos de la asignatura </th>
                            <th> Número de alumnos matriculados </th>
                                
                        </tr> 
                        <!--Mediante el siguiente bucle, accedemos sólo a los elementos asignatur que sean del tipo deseado-->
                        <xsl:for-each select="//asignatura[@ref='GPSI' or @ref='GINF']">
                            <!--Como queremos trabajar sobre 2 grados en concreto, guardaremos en dos variables 
                            los atributos ref y cod_asignatura-->
                            <xsl:variable name="id_grado" select="@ref"/> 
                            <xsl:variable name="id_asignatura" select="@cod_asignatura"/>      
                      
                                                             
                            <tr><!--Creamos la fila-->
                                <td> <!--Creamos la celda y vamos rellenando-->
                                    <xsl:value-of select="nombre"/>
                                </td>
                                <td><!--Mediante el siguiente bucle, accdemos a todos los elementos grado que cumpla la condición de 
 tener el atributo cod_grado igual que la variable id_grado, mediante el uso de variables el código es mas simple y legible-->
                                    <xsl:for-each select="//grado[@cod_grado=$id_grado]">
                                   
                                        <xsl:value-of select="nombre"/>
                                 
                                    </xsl:for-each>
                                </td>
                                <xsl:choose><!--Medinate "choose" se puede hacer que el xml resultante 
se comporte d euna forma u otra -->
                                    <xsl:when test="@turno='tarde'"><!--Mediante "when" se crean los comportamientos a verificar "test"
                                        indica la prueba a realizar como en este caso que si el atributo turno es tarde ,
 el fondo pantalla sea de color naranja-->
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
                                
                                <xsl:choose><!--Mediante "&lt" indicamos que el valor numérico que debemos comprobar para
realizar el comportamiento es que sean menor que 5 en este caso-->
                                    <xsl:when test="numero_creditos &lt; 5">
                                        <td align="center">
                                            <span style="color:red">
                                                <xsl:value-of select="numero_creditos"/>
                                            </span> 
                                        </td>
                                    </xsl:when><!--Mediante "&gt" y "&lt"indicamos que el rango de valores que debemos comprobar para
realizar el comportamiento , que en este caso es mayor de 5 y menor de 10-->
                                    <xsl:when test="numero_creditos &gt; 5 and numero_creditos &lt; 10">
                                        <td align="center">
                                            <span style="color:green">
                                                <xsl:value-of select="numero_creditos"/>
                                            </span> 
                                        </td>
                                    </xsl:when>    
                                    <xsl:otherwise><!--"Othewise" es el si no se cumple ninguna de las opciones anteriores,
 ejecuta esto, por defecto-->
                                        <td align="center">
                                            <span style="color:blue">
                                                <xsl:value-of select="numero_creditos"/>
                                            </span>
                                        </td>
                                    </xsl:otherwise>                             
                               
                                </xsl:choose>  
                                <td align="center" >
                                    <!--Contamos el número de alumnospor asignatura-->
                                   
                                    <xsl:value-of select="count (//alumno[@ref=$id_asignatura])"/>
                                 
                
                                </td>
                            </tr>
                        </xsl:for-each>  
                      
                    </table>  
                </div>     
                <div class="apartado4">
                    <h3> 4. Generar una tabla en .html, donde se muestre el nombre el nombre del grado, el 
                        número de asignaturas de cada grado y la suma total de créditos que existen para las asignaturas
                        de cada grado. </h3>
                    <table border="1"><!--Generamos la tabla-->
                        <tr>  <!--Generamos la fila-->
                            <th> Nombre del grado</th><!--Generamlos las cabeceras-->
                            <th> Número de asignaturas </th>
                            <th> Suma total de créditos </th>
                                  
                        </tr>  
                        <xsl:for-each select="//grado">  <!--Recorremos todos los elementos grado y guardamos en una variable el atributo "cod_grado"-->
                  
                            <xsl:variable name="cod_grado" select="@cod_grado"/> 
                      
                            <tr>
                                <td> <!--Mostramos en la celda los nombres-->
                                    <xsl:value-of select="nombre"/>
                                </td>
                                <td align="center">
                                    <!--Contamos cuantas veces se repite en todos los elementos asignatura, 
                                    una asignatura que tenga un atributo ref que sea igual a la variable que obtuvimos al inicio -->
                                                    
                                    <xsl:value-of select="count(//asignatura[@ref=$cod_grado])"/>
          
                                </td>
                                                            
                        
                                <td align="center">
                                    <!--Contamos cuantas veces se repite en todos los elementos asignatura, 
                                    una asignatura que tenga un atributo ref que sea igual a la variable que obtuvimos al inicio 
                                    y para hacer la media lo dividimos por el número de créditos de la asignatura-->
                                    <xsl:variable name="total_creditos" select="sum(//asignatura[@ref=$cod_grado]/numero_creditos)" />
                                    <!--Mostramos el valor de total_creditos-->
                                    <xsl:value-of select="$total_creditos" />
                                </td>
                    
                            </tr>
                        </xsl:for-each>  
                      
                    </table> 
                </div>        
                <div class="apartado5">
                    <h3> 5. Mostrar un resumen, donde se refleje un listado con el nombre de los alumnos matriculados
                        en cada asignatura. Además se debe de mostrar, el número de créditos de esa asignatura, el número de curso 
                        y el nombre del profesor que imparte esa asignatura. El formato en el que debe de quedar, aplicandole 
                        hojas de estilo, es tal y como se muestra en la siguiente imagen:
                    </h3>
                    
                    <div class="resumen">    <!--Mediante divs ,la etiqueta class y el css 
, le daremos forma gráficamente al html final-->
                    
                        <!--Recorremos todos los elementos asignatura ,
                        y almacenamos en variables todos los elemenntos que mostraremos-->
                        <xsl:for-each select="//asignatura">  
               
                            <xsl:variable name="nombre_profesor" select="nombre_profesor"/> 
                            <xsl:variable name="codigo_profesor" select="@cod_profesor"/>
                            <xsl:variable name="codigo_asignatura" select="@cod_asignatura"/>
                            <xsl:variable name="nombre_asignatura" select="nombre"/>
                            <xsl:variable name="numero_creditos" select="numero_creditos"/>
               
                            <!--Mediante section y el css vinculado, le daremos forma  al html formado-->
                            <section class="bloque">
                                <!--Por cada elemento asignatura, pues seguimos en el bucle-->
                                <p>Asignatura <xsl:value-of  select="$nombre_asignatura"/> 
                                </p>
                                <p>
                                    <ol> <!--Ceramos una lista ordenada -->
                                        <h5> <!--Lo saumos para mediante el css darle forma al html final-->
                                            <u>ALUMNOS MATRICULADOS: </u> 
                                        </h5><!--Recorremos todos los elementos alumno que tengan
un atributo ref igual a la variable del xsl codigo_asignatura,
 así mostramos sólo los alumnos de esa asignatura, y mostramos sus nombres-->
                                        <xsl:for-each select="//alumno[@ref=$codigo_asignatura]">
                            
                                            <li>  <!--Vamos añadiendo los elementos a la lista-->
                                                <xsl:value-of select="nombre"/> 
                                            </li>
                                        </xsl:for-each>
                                    </ol> 
                                </p>
                                <!--Mostramos los valores que deseamos mediante el uso de variables, permite gestionar mejor el código o
                                mostrando el atributo que deseemos como el "curso"-->
                                <p>Número de créditos <xsl:value-of select="$numero_creditos" /></p>
                                <p>Número de curso <xsl:value-of select="@curso" /></p>
                                <p>Nómbre del profesor <xsl:value-of select="$nombre_profesor"/> </p>
                              
                            </section>            
                                                                               
          
                        
                        </xsl:for-each>
                    </div>
                </div> 
            </body>
            <footer >
                José Carlos Manjón Carrasco
            </footer>
            
        </html>
    </xsl:template>

</xsl:stylesheet>
