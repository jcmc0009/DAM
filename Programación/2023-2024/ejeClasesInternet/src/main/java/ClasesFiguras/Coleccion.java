/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesFiguras;

import java.util.ArrayList;

/**
 *
 * @author JCMCarra
 */
public class Coleccion {

    private String nombreColeccion;
    private ArrayList<Figura> listaFiguras;

    public String getNombreColeccion() {
        return nombreColeccion;
    }

    public void setNombreColeccion(String nombreColeccion) {
        this.nombreColeccion = nombreColeccion;
    }

    public Coleccion(String nombreColeccion) {
        this.nombreColeccion = nombreColeccion;
        this.listaFiguras = new ArrayList<>();
    }

    public void añadirFigura(Figura fig) {
        this.listaFiguras.add(fig);
    }

    public void subirPrecio(double cantidad, String id) {
        for (Figura listaFigura : listaFiguras) {
            if (listaFigura.getCodigo().equals(id)) {
                listaFigura.subirPrecio(cantidad);
            }

        }

    }

    @Override
    public String toString() {
        String cadenaAdevolver = "la lista de figuras en la coleccion" + nombreColeccion + " son ";
        for (Figura listaFigura : listaFiguras) {
            cadenaAdevolver += listaFigura;

        }
        return cadenaAdevolver;
    }

    public String conCapa() {
        String concapa = "los superheroes con capa son ";
        for (Figura listaFigura : listaFiguras) {
            if (listaFigura.getSuperheroe().isCapa()) {
                concapa += listaFigura.getSuperheroe();
            }

        }
        return concapa;
    }

    public Figura masvalioso() {
 
            double precioMayor = 0.0;
        Figura fMayor = null;
        
        for(Figura f:listaFiguras) {
            if(f.getPrecio()>precioMayor) {
                precioMayor = f.getPrecio();
                fMayor = f;
            }
        }
        
        return fMayor;
    }
    public double getValorColeccion(){
        double precioTotal=0;
        for (Figura listaFigura : listaFiguras) {
            precioTotal+=listaFigura.getPrecio();

        }
        return precioTotal;
    }
    public double getVolumenColeccion() {
        double vol = 0;
        for(Figura f:listaFiguras) {
            vol += f.getDimension().getVolumen();
        }
        return vol+200;
    }
}
