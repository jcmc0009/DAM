package figuras;

/**
 *
 * @author Ana Espina Martínez
 */
public class Main {

    public static void main(String[] args) {
        
        Cuadrado cuadrado = new Cuadrado(5);
        
        System.out.println("Area: " + cuadrado.getArea());
        System.out.println("Perímetro: " + cuadrado.getPerimetro());
        
    }
    
}
