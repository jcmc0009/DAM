/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package factura;

import java.lang.reflect.Executable;
import java.time.LocalDate;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author José Carlos Manjón Carrasco
 */
public class PruebaFacturaIT {

    public PruebaFacturaIT() {
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
     * Test of main method, of class PruebaFactura.
     */
    @Test
    public void happyPath() throws Exception {
        System.out.println("Test happy path,todos parámetros válidos, no aplica descuento");

        int numeroFactura = 12345;
        LocalDate fechaEmision = LocalDate.of(2022, 1, 1);
        double baseImponible = 100.0;

        Factura miFactura = new Factura(numeroFactura, fechaEmision, baseImponible);
        double resultadoExperado = 121.0;
        double total = miFactura.calcularTotal();
        try {

            assertEquals(resultadoExperado, total, 0.001);

        } catch (Exception e) {
            /* no debería saltar ninguna excepción en este caso, 
            por lo que si lo hace es porque algo no está bien y el test debería fallar */
            fail("Se ha producido una excepción no esperada");
        }
    }
@Test
    public void descuentoIgualAcero() throws Exception {
        System.out.println("Se realiza un descuento igual a 0");

        int numeroFactura = 12345;
        LocalDate fechaEmision = LocalDate.of(2022, 1, 1);
        double baseImponible = 100.0;

        Factura miFactura = new Factura(numeroFactura, fechaEmision, baseImponible);
        double resultadoExperado = 121.0;
        miFactura.setDescuento(0);
        double total = miFactura.calcularTotal();
        try {

            assertEquals(resultadoExperado, total, 0.001);

        } catch (Exception e) {
            /* no debería saltar ninguna excepción en este caso, 
            por lo que si lo hace es porque algo no está bien y el test debería fallar */
            fail("Se ha producido una excepción no esperada");
        }
    }
    @Test
    public void testBaseImponibleIgualAcero() throws Exception {

        int numeroFactura = 12345;
        LocalDate fechaEmision = LocalDate.of(2022, 1, 1);
        double baseImponible = 0.0;
        //  PruebaFactura.main(args);
        Factura miFactura = new Factura(numeroFactura, fechaEmision, baseImponible);
        miFactura.setPorcentajeIva(20);
        try {
            miFactura.calcularTotal();
            fail("Base imponible 0");

        } catch (Exception e) {
            System.out.println(e);

        }

    }

    @Test
    public void testBaseImponibleMenorQueCero() throws Exception {

        int numeroFactura = 12345;
        LocalDate fechaEmision = LocalDate.of(2022, 1, 1);
        double baseImponible = -0.1;
        //  PruebaFactura.main(args);

        Factura miFactura = new Factura(numeroFactura, fechaEmision, baseImponible);
        try {
            miFactura.calcularTotal();
            fail("Base imponible menor que 0");

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Test
    public void ivaMenor0() throws Exception {
        // System.out.println("Iva menor que 0%");
        int numeroFactura = 12345;
        LocalDate fechaEmision = LocalDate.of(2022, 1, 1);
        double baseImponible = 50.0;
        Factura miFactura = new Factura(numeroFactura, fechaEmision, baseImponible);
        miFactura.setDescuento(0.1);
        try {
            miFactura.setPorcentajeIva(-0.1);
            miFactura.calcularTotal();
            fail("Iva negativo");
        } catch (Exception e) {

            System.out.println(e);
        }

    }
    @Test
    public void ivaIgualA0() throws Exception {
        // System.out.println("Iva menor que 0%");
        int numeroFactura = 12345;
        LocalDate fechaEmision = LocalDate.of(2022, 1, 1);
        double baseImponible = 50.0;
        Factura miFactura = new Factura(numeroFactura, fechaEmision, baseImponible);
        miFactura.setDescuento(0.1);
        try {
            miFactura.setPorcentajeIva(0);
            miFactura.calcularTotal();
            fail("Iva igual a 0");
        } catch (Exception e) {

            System.out.println(e);
        }

    }

    @Test
    public void ivaMayor21() throws Exception {
        int numeroFactura = 12345;
        LocalDate fechaEmision = LocalDate.of(2022, 1, 1);
        double baseImponible = 100.0;
        Factura miFactura = new Factura(numeroFactura, fechaEmision, baseImponible);
        miFactura.setDescuento(5);
        try {
            miFactura.setPorcentajeIva(21.1);
            miFactura.calcularTotal();
            fail("Mayor de 21");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Test
    public void descuentoValido() throws Exception {
        System.out.println("Descuento aplicado menor que baseImponible+Iva");
        int numeroFactura = 12345;
        LocalDate fechaEmision = LocalDate.of(2022, 1, 1);
        double baseImponible = 50.0;
        Factura miFactura = new Factura(numeroFactura, fechaEmision, baseImponible);
        double resultadoExperado = 59.95;
        try {
            miFactura.setDescuento(0.55);
            double total = miFactura.calcularTotal();
            assertEquals(resultadoExperado, total, 0.001);
        } catch (Exception e) {
            fail("Se ha producido una excepción no esperada");
            /* no debería saltar ninguna excepción en este caso, 
            por lo que si lo hace es porque algo no está bien y el test debería fallar */

        }
    }

    @Test
    public void descuentoNegativo() throws Exception {

        int numeroFactura = 12345;
        LocalDate fechaEmision = LocalDate.of(2022, 1, 1);
        double baseImponible = 100.0;
        Factura miFactura = new Factura(numeroFactura, fechaEmision, baseImponible);
        try {
            miFactura.setDescuento(-0.1);
            miFactura.calcularTotal();

            fail("Se ha producido una excepción esperada");
        } catch (Exception e) {
            System.out.println(e);

        }

    }

    @Test
    public void descuentoNoSentido() throws Exception {

        int numeroFactura = 12345;
        LocalDate fechaEmision = LocalDate.of(2022, 1, 1);
        double baseImponible = 100.0;
        Factura miFactura = new Factura(numeroFactura, fechaEmision, baseImponible);
        miFactura.setDescuento(121.1);
        try {
            miFactura.calcularTotal();
            fail("Se ha producido una excepción esperada: ");
        } catch (Exception e) {

            System.out.println(e);
        }
    }
}
