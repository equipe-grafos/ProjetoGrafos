import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        //LinkedList<Vertice> grafo = new LinkedList<Vertice>();
        Grafo grafo = new Grafo();

        Vertice vertice1 = new Vertice();
        Vertice vertice2 = new Vertice();
        Vertice vertice3 = new Vertice();
        Vertice vertice4 = new Vertice();

        vertice1.addAresta(vertice2);
        vertice2.addAresta(vertice3);
        vertice3.addAresta(vertice4);
        vertice1.addAresta(vertice4);

        grafo.addVertice(vertice1);
        grafo.addVertice(vertice2);
        grafo.addVertice(vertice3);
        grafo.addVertice(vertice4);

        bfs(grafo, vertice1);
        
    }

    public static void bfs(Grafo grafo, Vertice vertice){

        Queue<Vertice> fila = new LinkedList<Vertice>();
        
        //int idVertice = vertice.getId();

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

    /*

    BFS (grafo G, vértice s)
        para cada vértice u
            cor[u] = BRANCO; d[u] = ; ante[u] = NIL;
        cor[s] = CINZA; d[s] = 0;
        Enfileira(Q, s);

        While ( ! EstahVazia(Q) )
            u = Desenfileira(Q);
            para cada v na lista Adj[u]
                if (cor[v] == BRANCO)
                cor[v] = CINZA; d[v] = d[u]+1; ante[v] = u;
                Enfileira (v, Q);

            cor[u] = PRETO;

    */
    
}