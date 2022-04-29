package grafos_algoritimos;

import java.util.LinkedList;

public class Vertice {
    
    private int id;

    private String cor;
    private Double distancia;
    private LinkedList<Vertice> adjacentes;
    private Vertice anterior;

    public Vertice(){
        id++;
    }

    public String getCor(){
        return this.cor;
    }

    public void setCor(String cor){
        this.cor = cor;
    }

    public Double getDistancia() {
        return this.distancia;
    }

    public void setDistancia(Double distancia){
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

    public LinkedList<Vertice> getAdjacentes() {
        return adjacentes;
    }

}
