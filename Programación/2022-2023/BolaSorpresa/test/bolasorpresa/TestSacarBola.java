/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package bolasorpresa;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Elena
 */
public class TestSacarBola {
    
    public TestSacarBola() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of sacarBolaSorpresas1 method, of class BolaSorpresa.
     */
    @Test
    public void testSacarBolaSorpresas1() {
        System.out.println("sacarBolaSorpresas");
        int numbolas = 3;//Sale 0 por defecto. Voy a sacar 3bolas en esta prueba
        BolaSorpresa instance = new BolaSorpresa(15,2,5);//Creamos una intancia de la clase BolaSorpresa llamando al constructor
        instance.sacarBolaSorpresas(numbolas);//Se añaden las tres filas siguientes
        int expResult = 12; //Valor esperado de la ejecución (15-3=12) 
        int result = instance.getUnidades();
        assertEquals(expResult, result);
    }  
    
        /**
     * Test of sacarBolaSorpresas2 method, of class BolaSorpresa.
     */
    @Test
    public void testSacarBolaSorpresas2() {
        System.out.println("sacarBolaSorpresas");
        int numbolas = 10;//Sale 0 por defecto. Voy a sacar 10 bolas en esta prueba
        BolaSorpresa instance = new BolaSorpresa(10,2,5);
        //Creamos una intancia de la clase BolaSorpresa llamando al constructor (10 disponbibles, precio 2, precioMax5)
        instance.sacarBolaSorpresas(numbolas);//Se añaden las tres filas siguientes
        int expResult = 0; //Valor esperado de la ejecución (15-3=12) 
        int result = instance.getUnidades();
        assertEquals(expResult, result);
    }  
    
        /**
     * Test of sacarBolaSorpresas3 method, of class BolaSorpresa.
     */
    @Test
    public void testSacarBolaSorpresas3() {
        System.out.println("sacarBolaSorpresas");
        int numbolas = 5;//Sale 0 por defecto. Voy a sacar 5 bolas en esta prueba
        BolaSorpresa instance = new BolaSorpresa(3,2,5);
         //Creamos una intancia de la clase BolaSorpresa llamando al constructor (3 disponbibles, precio 2, precioMax5)
        instance.sacarBolaSorpresas(numbolas);//Se añaden las tres filas siguientes
        int expResult = 3; //Valor esperado de la ejecución (15-3=12) 
        int result = instance.getUnidades();
        assertEquals(expResult, result);
    }  
    
        /**
     * Test of sacarBolaSorpresas4 method, of class BolaSorpresa.
     */
    @Test
    public void testSacarBolaSorpresas4() {
        System.out.println("sacarBolaSorpresas");
        int numbolas = 1;//Sale 0 por defecto. Voy a sacar 1 bolas en esta prueba
        BolaSorpresa instance = new BolaSorpresa(0,2,5);
        //Creamos una intancia de la clase BolaSorpresa llamando al constructor (0 disponbibles, precio 2, precioMax5)
        instance.sacarBolaSorpresas(numbolas);//Se añaden las tres filas siguientes
        int expResult = 0; //Valor esperado de la ejecución (15-3=12) 
        int result = instance.getUnidades();
        assertEquals(expResult, result);
    }  
    
    
      
}
