/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut8_utilidades;

/**
 *
 * @author Luis Navarro
 */
public class SimuladorLectorValores {

    int contador = 0;
    int numeroValores = 10 + (int) (Math.random() * 10);
    int limiteSuperior = 10;
    int limiteInferior = 0;
    int limitesSuperiores[];
    int limitesInferiores[];

    public SimuladorLectorValores(int numMinValores, int numMaxValores, int limiteInferior, int limiteSuperior) {
        numeroValores = numMinValores + (int) ((numMaxValores - numMinValores+1) * Math.random());
        this.limiteInferior = limiteInferior;
        this.limiteSuperior = limiteSuperior;
    }

    public SimuladorLectorValores(int numMaxV, int limiteSup) {
        this(0, numMaxV, 0, limiteSup);
    }

    public int[] leeTupla() {
        int[] tupla = new int[limitesInferiores.length];
        for (int i = 0; i < limitesInferiores.length; i++) {
            tupla[i] = generaAleatorioEntre(limitesInferiores[i], limitesSuperiores[i]);
        }
        return tupla;
    }

    public int leeValor() {
        if (contador++ == numeroValores) {
            return -1;
        }
        return limiteInferior + (int) ((limiteSuperior - limiteInferior+1) * Math.random());
    }

    public void setLimitesSuperiores(int[] arrayLimitesSuperiores) {
        limitesSuperiores = arrayLimitesSuperiores;
    }

    public void setLimitesInferiores(int[] arrayLimitesInferiores) {
        limitesInferiores = arrayLimitesInferiores;
    }

    public int generaAleatorioEntre(int inferior, int superior) {
        return inferior + (int) ((superior - inferior+1) * Math.random());
    }
}
