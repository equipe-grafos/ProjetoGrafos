import Algoritmos.Algoritmo;
import Algoritmos.AlgoritmoBFS;
import Grafo.Grafo;
import Grafo.Vertice;

public class Main {
    public static void main(String[] args) {

        Algoritmo algoritmo = new AlgoritmoBFS();

        Grafo grafo = new Grafo();

        Vertice vertice1 = new Vertice();
        Vertice vertice2 = new Vertice();
        Vertice vertice3 = new Vertice();
        Vertice vertice4 = new Vertice();
        Vertice vertice5 = new Vertice();
        Vertice vertice6 = new Vertice();
        Vertice vertice7 = new Vertice();

        vertice1.addAresta(vertice2);
        vertice2.addAresta(vertice3);
        vertice3.addAresta(vertice4);
        vertice1.addAresta(vertice4);
        vertice4.addAresta(vertice5);
        vertice5.addAresta(vertice6);
        vertice6.addAresta(vertice7);

        grafo.addVertice(vertice1);
        grafo.addVertice(vertice2);
        grafo.addVertice(vertice3);
        grafo.addVertice(vertice4);
        grafo.addVertice(vertice5);
        grafo.addVertice(vertice6);
        grafo.addVertice(vertice7);

        algoritmo.buscar(grafo, vertice1);

        imprimirMenorCaminho(vertice1, vertice7);
        System.out.println();
        
    }

    public static void imprimirMenorCaminho(Vertice verticeA, Vertice verticeB) {
        if(verticeA.equals(verticeB) ) {
            System.out.print(verticeB);
        } else {
            if(verticeB.getAnterior() == null){
                System.out.println("não há caminho! ");
            }else{
                imprimirMenorCaminho(verticeA, verticeB.getAnterior());
                System.out.print(" ---> ");
                System.out.print(verticeB);
            }
        }
    }

    
}