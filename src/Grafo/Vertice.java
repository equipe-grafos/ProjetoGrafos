package Grafo;
import java.util.LinkedList;

public class Vertice {

    private static int sequence = 0;

    private int id;

    private String cor;
    private double distancia;
    private Vertice anterior;
    private double custo;
    private LinkedList<Aresta> arestas;
    private LinkedList<String> locais;

    public Vertice() {
        id = sequence++;
        arestas = new LinkedList<>();
        locais = new LinkedList<>();
    }

    public int getId() {
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

    public double getCusto() {
        return this.custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
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

    public void addAresta(Vertice vertice) {
        Aresta newAresta = new Aresta(vertice);
        this.arestas.add(newAresta);
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
        return String.format("(%d)", this.id);
    }

}
