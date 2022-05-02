package grafos_algoritimos;

import java.util.LinkedList;

public class Grafo {

    private LinkedList<Vertice> vertices;

    public Grafo(){
        this.vertices = new LinkedList<>();
    }

    public LinkedList<Vertice> getVertices() {
        return vertices;
    }

    public void addVertice(Vertice vertice){
        this.vertices.add(vertice);
    }

    public Vertice searchElement(Vertice vertice) {
        for (Vertice verticeAtual : vertices) {
            if(verticeAtual.equals(vertice)){
                return vertice;
            }
        }
        return null;
    }

}
