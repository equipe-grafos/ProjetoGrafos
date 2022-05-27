package Algoritmos.Busca;

import java.util.Collections;
import java.util.LinkedList;

import Grafo.Grafo;
import Grafo.Vertice;

public class AlgoritmoDijkstra implements Algoritmo {

    @Override
    public void buscar(Grafo grafo, Vertice vertice) {
        LinkedList<Vertice> lista = new LinkedList<>();
        inicializa(grafo, vertice);
        lista = addVertices(grafo);
        Collections.sort(lista);
        while(!lista.isEmpty()){
            Collections.sort(lista);
            Vertice verticeAtual;
            verticeAtual = lista.removeFirst();
            for (Vertice adjacente : verticeAtual.getAdjacentes()) {
                relaxar(verticeAtual, adjacente, verticeAtual.getCusto(adjacente) );
            } 
        }
    }

    public static void inicializa(Grafo grafo, Vertice verticeAtual) {
        for (Vertice proximoVertice : grafo.getVertices()) {
            proximoVertice.setCustoLocal(Double.POSITIVE_INFINITY);
            proximoVertice.setAnterior(null);
            proximoVertice.setCustoAresta(Double.POSITIVE_INFINITY);
        }
        verticeAtual.setCustoLocal(0);
        verticeAtual.setCustoAresta(0);
    }

    public static void relaxar(Vertice verticeA, Vertice verticeB, double peso) {
        if((verticeA.getCustoLocal() + peso) < verticeB.getCustoLocal()){
            double novoCusto = verticeA.getCustoLocal() + peso;
            verticeB.setCustoLocal(novoCusto);
            verticeB.setCustoAresta(peso);
            verticeB.setAnterior(verticeA);
        }
    }

    public static LinkedList<Vertice> addVertices(Grafo grafo) {   
        LinkedList<Vertice> fila = new LinkedList<>();
        for (Vertice vertice : grafo.getVertices()) {
            fila.add(vertice);
        }
        return fila;
    }

    /* public static LinkedList<Vertice> addVertices(Grafo grafo, Vertice vertice) {
        LinkedList<Vertice> list = new LinkedList<>();
        list.add(vertice);
        for (Vertice currentVertice : vertice.getAdjacentes()) {
            if(!list.contains(currentVertice)) {
                list.add(currentVertice);
            }
        }
    } */


}
