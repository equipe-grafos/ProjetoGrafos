import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Scanner;

import Algoritmos.Busca.Algoritmo;
import Algoritmos.Busca.AlgoritmoBFS;
import Algoritmos.Busca.AlgoritmoDijkstra;
import Algoritmos.Colorir.Colore;
import Grafo.Aresta;
import Grafo.Grafo;
import Grafo.Vertice;

public class Main {

    public static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {
        
        int opcao;
        Grafo grafo = new Grafo();
        String[] arquivoVertices = lerArquivo("vertices.txt");
        String[] arquivoArestas = lerArquivo("arestas.txt");
        LinkedList<Vertice> vertices = criarVertices(arquivoVertices);
        Colore colore;

        String[] cores = {"azul", "vermelho", "verde", "roza", "amarelo", "preto", "cinza", "branco"};

        grafo.setListaVertices(vertices);
        criarArestasAddGrafo(grafo, arquivoArestas);

        colore = new Colore(grafo, cores);
        colore.coloreGrafo();

        menuPrincipal();
        opcao = ler.nextInt();

        while(opcao <= 3) {
            switch(opcao) {
                case 1: imprimeVertices(grafo);
                    break;
                case 2: menorCaminhoBFS(grafo);
                    break;
                case 3: menorCaminhoDijkstra(grafo);
                    break;
                default: 
                    break;
            }
            menuPrincipal();
            opcao = ler.nextInt();
        }
        
    }

    public static void menorCaminhoBFS(Grafo grafo) {
        ler.nextLine();
        System.out.format("Nome do vertice A: ");
        String idA = ler.nextLine();
        System.out.format("Nome do vertice B: ");
        String idB = ler.nextLine();
        Vertice verticeA = grafo.getVerticeByID(idA);
        Vertice verticeB = grafo.getVerticeByID(idB);
        Algoritmo algoritmo = new AlgoritmoBFS();
        algoritmo.buscar(grafo, verticeA);
        System.out.println();
        imprimirMenorCaminho(verticeA, verticeB);
        System.out.println();
        double custoTotal = calculaCustoTotal(verticeA, verticeB);
        System.out.println("Custo total = " + custoTotal);
    }

    public static void menorCaminhoDijkstra(Grafo grafo) {
        ler.nextLine();
        System.out.format("Nome do vertice A: ");
        String idA = ler.nextLine();
        System.out.format("Nome do vertice B: ");
        String idB = ler.nextLine();
        Vertice verticeA = grafo.getVerticeByID(idA);
        Vertice verticeB = grafo.getVerticeByID(idB);
        Algoritmo algoritmo = new AlgoritmoDijkstra();
        algoritmo.buscar(grafo, verticeA);
        System.out.println();
        imprimirMenorCaminho(verticeA, verticeB);
        System.out.println();
        double custoTotal = calculaCustoTotal(verticeA, verticeB);
        System.out.println("Custo total = " + custoTotal);
    }

    public static void menuPrincipal() {
        System.out.println("===================================");
        System.out.format("Selecione uma opção: %n"
            + "1 - Vizualizar Grafo %n"
            + "2 - Buscar menor caminho BFS %n"
            + "3 - Buscar menor caminho Dijkstra %n"
            + "Digite: ");
    }

    public static void imprimeVertices(Grafo grafo) {
        System.out.format("%n %n=================================== %n");
        System.out.format("%n Grafo Unicap %n %n %n");
        for (Vertice verticeAtual : grafo.getVertices()) {
            System.out.format(" [%s : %s]", verticeAtual, verticeAtual.getCorDoVertice());
            for (Vertice adjacente : verticeAtual.getAdjacentes()) {
                System.out.format("%n -----------------> [%s : %.2f : %s] %n", adjacente, verticeAtual.getCusto(adjacente), adjacente.getCorDoVertice());
            }
            System.out.format("%n %n %n");
        }
    }

    public static void imprimirMenorCaminho(Vertice verticeA, Vertice verticeB) {
        if(verticeA.equals(verticeB) ) {
            System.out.format("[%s : %.2f]",verticeB, verticeB.getCustoAresta());
        } else {
            if(verticeB.getAnterior() == null){
                System.out.println("não há caminho! ");
            }else{
                imprimirMenorCaminho(verticeA, verticeB.getAnterior());
                System.out.print(" <--> ");
                System.out.format("[%s : %.2f]",verticeB, verticeB.getCustoAresta());
            }
        }
    }

    public static double calculaCustoTotal(Vertice verticeA, Vertice verticeB) {
        if(verticeA.equals(verticeB) ) {
            return verticeB.getCustoAresta();
        } else {
            if(verticeB.getAnterior() == null){
                return Double.POSITIVE_INFINITY;
            }else{
                return calculaCustoTotal(verticeA, verticeB.getAnterior()) + verticeB.getCustoAresta();
            }
        }
    }

    public static String[] lerArquivo(String nomeArquivo) {
        String palavra = "";
        try {
            palavra = new String(Files.readAllBytes(Paths.get(nomeArquivo)), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] palavras = palavra.split("\r*\n");
        return palavras;
    }

    public static LinkedList<Vertice> criarVertices(String[] palavras) {
        LinkedList<Vertice> vertices = new LinkedList<>();
        for (String id : palavras) {
            Vertice novoVertice = new Vertice(id);
            vertices.add(novoVertice);
        }
        return vertices;
    }

    public static void criarArestasAddGrafo(Grafo grafo, String[] palavras) {
        String[] linha = new String[palavras.length];
        String[] verticeA = new String[palavras.length];
        String[] verticeB = new String[palavras.length];
        String[] peso = new String[palavras.length];
        for (int i = 0; i < palavras.length; i++) {
            linha[i] = String.valueOf(palavras[i]);
            verticeA[i] = linha[i].split(";")[0];
            verticeB[i] = linha[i].split(";")[1];
            peso[i] = linha[i].split(";")[2];
            Vertice verticeAAtual = grafo.getVerticeByID(verticeA[i]);
            Vertice verticeBAtual = grafo.getVerticeByID(verticeB[i]);
            int pesoAtual = Integer.parseInt(peso[i]);
            Aresta novAresta = new Aresta(verticeBAtual, pesoAtual);
            verticeAAtual.addAresta(novAresta);
        }
    }
    
}