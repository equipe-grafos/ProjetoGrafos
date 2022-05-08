import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Scanner;

import Algoritmos.Algoritmo;
import Algoritmos.AlgoritmoBFS;
import Algoritmos.AlgoritmoDijkstra;
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
        grafo.setListaVertices(vertices);
        criarArestasAddGrafo(grafo, arquivoArestas);
       
        menuPrincipal();
        opcao = ler.nextInt();

        while(opcao <= 3) {

            switch(opcao) {
                case 1: imprimeVertices(grafo);
                    break;
                case 2: imprimeMenorCaminhoBFS(grafo);
                    break;
                case 3: imprimeMenorCaminhoDijkstra(grafo);
                    break;
                default:
                    break;
            }

            menuPrincipal();
            opcao = ler.nextInt();

        }

        


       /*  Algoritmo algoritmo = new AlgoritmoBFS();

        algoritmo.buscar(grafo, vertice1);

        imprimirMenorCaminho(vertice1, vertice7);
        System.out.println(); */
        
    }

    public static void menuPrincipal() {
        System.out.println("==============================");
        System.out.format("Selecione uma opção: %n"
            + "1 - Vizualizar Grafo %n"
            + "2 - Buscar menor caminho BFS %n"
            + "3 - Buscar menor caminho Dijkstra %n"
            + "Digite: ");
    }

    public static void imprimeVertices(Grafo grafo) {
        for (Vertice verticeAtual : grafo.getVertices()) {
            System.out.println(verticeAtual);
        }
    }

    public static void imprimirMenorCaminho(Vertice verticeA, Vertice verticeB) {
        if(verticeA.equals(verticeB) ) {
            System.out.print(verticeB);
        } else {
            if(verticeB.getAnterior() == null){
                System.out.println("não há caminho! ");
            }else{
                imprimirMenorCaminho(verticeA, verticeB.getAnterior());
                System.out.print(" ---> ");
                System.out.print(verticeB);
            }
        }
    }

    public static double calculaCustoTotal(Vertice verticeA, Vertice verticeB) {
        
        if(verticeA.equals(verticeB) ) {
            return verticeB.getCusto(verticeA);
        } else {
            if(verticeB.getAnterior() == null){
                return 0;
            }else{
                return calculaCustoTotal(verticeA, verticeB.getAnterior()) + verticeB.getCusto(verticeA);
            }
        }
    }

    public static void imprimeMenorCaminhoBFS(Grafo grafo) {
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
        double custoTotal = calculaCustoTotal(verticeA, verticeB);
        System.out.println();
        System.out.println("Custo total do menor caminho: " + custoTotal);
    }

    public static void imprimeMenorCaminhoDijkstra(Grafo grafo) {
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
        double custoTotal = calculaCustoTotal(verticeA, verticeB);
        System.out.println();
        System.out.println("Custo total do menor caminho: " + custoTotal);
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