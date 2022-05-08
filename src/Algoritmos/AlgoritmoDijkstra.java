package Algoritmos;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import Grafo.Grafo;
import Grafo.Vertice;

public class AlgoritmoDijkstra implements Algoritmo {

    @Override
    public void buscar(Grafo grafo, Vertice vertice) {
        Queue<Vertice> lista = new LinkedList<>();
        
        inicializa(grafo, vertice);

        lista = addVertices(grafo);

        while(!lista.isEmpty()){

            Vertice verticeAtual;
            verticeAtual = lista.remove();

            for (Vertice adjacente : verticeAtual.getAdjacentes()) {
                relaxar(verticeAtual, adjacente, verticeAtual.getCusto(adjacente) );
            } 
            
        }
        
    }

    public static void inicializa(Grafo grafo, Vertice verticeAtual) {
        for (Vertice proximoVertice : verticeAtual.getAdjacentes()) {
            proximoVertice.setCusto(Double.POSITIVE_INFINITY);
            proximoVertice.setAnterior(null);
        }
        verticeAtual.setCusto(0);
    }

    public static void relaxar(Vertice verticeA, Vertice verticeB, double peso) {
        if((verticeA.getCusto(verticeB) + peso) < verticeB.getCusto(verticeB)){
            double novoCusto = verticeA.getCusto(verticeB) + peso;
            verticeB.setCusto(novoCusto);
            verticeB.setAnterior(verticeA);
        }
    }

    public static PriorityQueue<Vertice> addVertices(Grafo grafo) {

        PriorityQueue<Vertice> priorityQueue = new PriorityQueue<>();

        priorityQueue.addAll(grafo.getVertices());

        return priorityQueue;
        
    }
    
}
