import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

        Grafo grafo = new Grafo();

        Vertice vertice1 = new Vertice();
        Vertice vertice2 = new Vertice();
        Vertice vertice3 = new Vertice();
        Vertice vertice4 = new Vertice();
        Vertice vertice5 = new Vertice();

        vertice1.addAresta(vertice2);
        vertice2.addAresta(vertice3);
        vertice3.addAresta(vertice4);
        vertice1.addAresta(vertice4);

        grafo.addVertice(vertice1);
        grafo.addVertice(vertice2);
        grafo.addVertice(vertice3);
        grafo.addVertice(vertice4);
        grafo.addVertice(vertice5);

        bfs(grafo, vertice1);

        imprimirMenorCaminho(vertice1, vertice5);
        
    }

    public static void bfs(Grafo grafo, Vertice vertice){

        Queue<Vertice> fila = new LinkedList<Vertice>();

        for (Vertice verticeAtual : grafo.getVertices()) {
            verticeAtual.setCor("BRANCO");
            verticeAtual.setDistancia(Double.POSITIVE_INFINITY);
            verticeAtual.setAnterior(null);
        }

        vertice.setCor("CINZA");
        vertice.setDistancia(0.0);
        
        fila.add(vertice);

        while (!fila.isEmpty()) {
            Vertice verticeAtual;
            verticeAtual = fila.remove();
            for (Vertice adjacente : verticeAtual.getAdjacentes()) {
                if (adjacente.getCor().equals("BRANCO")){
                    adjacente.setCor("CINZA");
                    adjacente.setDistancia(verticeAtual.getDistancia() + 1);
                    adjacente.setAnterior(verticeAtual);
                    fila.add(adjacente);
                }
            }
            verticeAtual.setCor("PRETO");
        }

    }



    public static void imprimirMenorCaminho(Vertice verticeA, Vertice verticeB) {
        if(verticeA.equals(verticeB) ) {
            System.out.print(verticeB);
        } else {
            if(verticeB.getAnterior() == null){
                System.out.println("não ha caminho! ");
            }else{
                imprimirMenorCaminho(verticeA, verticeB.getAnterior());
                System.out.print(" ---> ");
                System.out.print(verticeB);
            }
        }
    }
    
}