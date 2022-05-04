package grafos_algoritimos;

import java.util.LinkedList;

public class Vertice {

    private static int sequence = 0;
    
    private int id;

    private String cor;
    private double distancia;
    private Vertice anterior;
    //private LinkedList<Vertice> adjacentes;
    private LinkedList<Aresta> arestas;
    private LinkedList<String> pontos;

    public Vertice(){
        id = sequence++;
        arestas = new LinkedList<>();
        pontos = new LinkedList<>();
    }

    public String getCor(){
        return this.cor;
    }

    public void setCor(String cor){
        this.cor = cor;
    }

    public double getDistancia() {
        return this.distancia;
    }

    public void setDistancia(double distancia){
        this.distancia = distancia;
    }

    public Vertice getAnterior(){
        return this.anterior;
    }

    public void setAnterior(Vertice anterior){
        this.anterior = anterior;
    }

    public int getId() {
        return this.id;
    }

    public void addAresta(Vertice vertice) {
        Aresta newAresta = new Aresta(vertice);
        this.arestas.add(newAresta);
    }

    public LinkedList<Vertice> getAdjacentes() {
        LinkedList<Vertice> adjacentes = new LinkedList<>();
        if(!arestas.isEmpty()){
            for (Aresta aresta : this.arestas) {
                adjacentes.add(aresta.getVertice());
            }
        }
        return adjacentes;
    }

    /* public void addAdjacente(Vertice adjacente){
        this.adjacentes.add(adjacente);
        adjacente.addAdjacente(this);
    } */

    @Override
    public boolean equals(Object object) {
        if(!(object instanceof Vertice)) {
            return false;
        }
        Vertice anotherVertice = (Vertice) object;
        return this.id == anotherVertice.id;
    }

    // comentario para commit 

}
