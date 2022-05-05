package Algoritmos;

import Grafo.Grafo;
import Grafo.Vertice;

public class AlgoritmoDijkstra implements Algoritmo {

    @Override
    public void buscar(Grafo grafo, Vertice vertice) {
        
        
    }

    public static void inicializa(Grafo grafo, Vertice vertice) {
        for (Vertice verticeAtual : vertice.getAdjacentes()) {
            verticeAtual.setCusto(Double.POSITIVE_INFINITY);
            verticeAtual.setAnterior(null);
        }
        vertice.setCusto(0);
    }

    public static void relaxar(Vertice verticeA, Vertice verticeB, double peso) {
        if((verticeA.getCusto() + peso) < verticeB.getCusto()){
            double novoCusto = verticeA.getCusto() + peso;
            verticeB.setCusto(novoCusto);
            verticeB.setAnterior(verticeA);
        }
    }
    
}
