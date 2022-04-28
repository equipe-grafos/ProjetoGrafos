package grafos_algoritimos;
public class Vertice {
    
    private String cor;
    private Integer distancia;
    private Vertice anterior;

    public Vertice(){
        
    }

    public String getCor(){
        return this.cor;
    }

    public void setCor(String cor){
        this.cor = cor;
    }

    public Integer getDistancia() {
        return this.distancia;
    }

    public void setDistancia(Integer distancia){
        this.distancia = distancia;
    }

    public Vertice getAnterior(){
        return this.anterior;
    }

    public void setAnterior(Vertice anterior){
        this.anterior = anterior;
    }
}
