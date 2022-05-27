package Algoritmos.Colorir;

import Grafo.Grafo;
import Grafo.Vertice;

public class Colore {

    private Grafo grafo;
    private String[] cores;

    public Colore (Grafo grafo, String[] cores) {
        this.grafo = grafo;
        this.cores = cores;
    }

    public void coloreGrafo() {
        inicializaCores(this.grafo, this.cores);
        for (int i = 1; i < this.grafo.getVertices().size(); i++) {
            Vertice vertice = this.grafo.getVertices().get(i);
            pintaVertice(vertice, this.cores);
        }
    }

    public static void pintaVertice(Vertice vertice, String[] cores) {
        for (int k = 0; k < cores.length; k++) {
            if(podeEssaCor(vertice, cores[k])) {
                vertice.setCorDoVertice(cores[k]);
                return;
            }
        }
    }

    public static boolean podeEssaCor(Vertice vertice, String cor) {
        for (Vertice adjacente : vertice.getAdjacentes()) {
            if(adjacente.getCorDoVertice().equals(cor)){
                return false;
            }
        }
        return true;
    }

    public static void inicializaCores(Grafo grafo, String[] cores) {
        for (Vertice vertice : grafo.getVertices()) {
            vertice.setCorDoVertice("");
        }
        grafo.getVertices().get(0).setCorDoVertice(cores[0]);
    }
}
