package Grafo;
import java.util.LinkedList;

public class Vertice implements Comparable {

    private String id;

    private String cor;
    private double distancia;
    private Vertice anterior;
    private double custo;
    private Vertice verticeAnterior;
    private LinkedList<Aresta> arestas;
    private LinkedList<String> locais;

    public Vertice(String id) {
        this.id = id;
        arestas = new LinkedList<>();
        locais = new LinkedList<>();
    }

    public String getId() {
        return this.id;
    }

    public String getCor() {
        return this.cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getDistancia() {
        return this.distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public Vertice getAnterior() {
        return this.anterior;
    }

    public void setAnterior(Vertice anterior) {
        this.anterior = anterior;
    }

    public double getCusto(Vertice vertice) {
        for (Aresta aresta : this.arestas) {
            if(aresta.getVertice().equals(vertice)) {
                this.verticeAnterior = aresta.getVertice();
                return aresta.getCusto();
            }
        }
        return 0;
    }

    public void setCusto(double custo) {
        for (Aresta aresta : this.arestas) {
            if(aresta.getVertice().equals(verticeAnterior)) {
                aresta.setCusto(custo);
            }
        }
    }

    public LinkedList<String> getLocais() {
        return locais;
    }

    public void addLocal(String local) {
        this.locais.add(local);
    }

    public void removeLocal(String local) {
        this.locais.remove(local);
    }

    public void addAresta(Aresta aresta) {
        this.arestas.add(aresta);
    }
    

    public LinkedList<Vertice> getAdjacentes() {
        LinkedList<Vertice> adjacentes = new LinkedList<>();
        if (!arestas.isEmpty()) {
            for (Aresta aresta : this.arestas) {
                adjacentes.add(aresta.getVertice());
            }
        }
        return adjacentes;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Vertice)) {
            return false;
        }
        Vertice anotherVertice = (Vertice) object;
        return this.id == anotherVertice.id;
    }

    @Override
    public String toString() {
        return String.format("[%s : %.2f]", this.id, this.custo);
    }

    @Override
    public int compareTo(Object object) {

        Vertice vertice = (Vertice) object;

        if(this.custo == vertice.custo) {
            return 0;
        } else if(this.custo > vertice.custo) {
            return 1;
        } else{
            return -1;
        }
        
    }

}
