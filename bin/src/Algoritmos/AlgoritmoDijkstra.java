package Algoritmos;

import java.util.LinkedList;
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
        for (Vertice proximoVertice : grafo.getVertices()) {
            proximoVertice.setCustoLocal(Double.POSITIVE_INFINITY);
            proximoVertice.setAnterior(null);
        }
        verticeAtual.setCustoLocal(0);
    }

    public static void relaxar(Vertice verticeA, Vertice verticeB, double peso) {
        if((verticeA.getCustoLocal() + peso) < verticeB.getCustoLocal()){
            double novoCusto = verticeA.getCustoLocal() + peso;
            verticeB.setCustoLocal(novoCusto);
            verticeB.setCustoAresta(peso);
            verticeB.setAnterior(verticeA);
        }
    }

    public static Queue<Vertice> addVertices(Grafo grafo) {   
        LinkedList<Vertice> fila = new LinkedList<>();
        LinkedList<Vertice> queue = new LinkedList<>();
        for (Vertice vertice : grafo.getVertices()) {
            fila.add(vertice);
        }
        while(!fila.isEmpty()) {
            Vertice verticeAtual = fila.removeFirst();
            if(!verticeAtual.getAdjacentes().isEmpty()) {
                queue.add(verticeAtual);
                for (Vertice vertice : verticeAtual.getAdjacentes()) {
                    fila.remove(vertice);
                    queue.add(vertice);
                }
            }else {
                queue.addLast(verticeAtual);
            }
        }
        return queue;
    }
    
}
