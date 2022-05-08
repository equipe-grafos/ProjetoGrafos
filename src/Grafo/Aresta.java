package Grafo;
public class Aresta {

    private Vertice vertice;
    private double custo;

    public Aresta(Vertice vertice, int custo) {
        this.vertice = vertice;
        this.custo = custo;
    }

    public Vertice getVertice() {
        return vertice;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

}