package grafos_algoritimos;

import java.util.LinkedList;

public class Grafos {
    public static void main(String[] args) {
        LinkedList<Vertice> grafos = new LinkedList<>();
    }

    public static void bfs(LinkedList<Vertice> grafos, Vertice vertice){
        LinkedList<Vertice> fila = new LinkedList<>();
        int tamGrafo = grafos.size();

        for(int i = 0; i < tamGrafo; i++){
            grafos.get(i).setCor("BRANCO");
            grafos.get(i).setDistancia(null);
            grafos.get(i).setAnterior(null);
        }
        primeiroVertice.setCor("CINZA");
        primeiroVertice.setDistancia(0);

        fila.add(primeiroVertice);

        while (fila.isEmpty()) {
            
        }
        

        
        
        /*
        for(int i = 0; i < tamGrafo; i++){
            
        }

        for (Integer integer : grafos) {
            
        }

        */

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