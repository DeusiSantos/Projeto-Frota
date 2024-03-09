package frota;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class GrafoCidades {
    private Map<String, Map<String, Integer>> adjacencyList;

    public GrafoCidades() {
        this.adjacencyList = new HashMap<>();
    }

    public void adicionarCidade(String cidade) {
        adjacencyList.put(cidade, new HashMap<>());
    }

    public void adicionarEstrada(String cidadeOrigem, String cidadeDestino, int quilometros) {
        adjacencyList.get(cidadeOrigem).put(cidadeDestino, quilometros);
        adjacencyList.get(cidadeDestino).put(cidadeOrigem, quilometros); // Se for bidirecional
    }

    public int obterQuilometros(String cidadeOrigem, String cidadeDestino) {
        return adjacencyList.get(cidadeOrigem).getOrDefault(cidadeDestino, -1);
    }

    public class CaminhoMaisCurto {
        private List<String> caminho;
        private int distanciaTotal;

        public CaminhoMaisCurto(List<String> caminho, int distanciaTotal) {
            this.caminho = caminho;
            this.distanciaTotal = distanciaTotal;
        }

        public List<String> getCaminho() {
            return caminho;
        }

        public int getDistanciaTotal() {
            return distanciaTotal;
        }
    }

    public CaminhoMaisCurto caminhoMaisCurto(String cidadeOrigem, String cidadeDestino) {
        Map<String, Integer> distancia = new HashMap<>();
        Map<String, String> predecessores = new HashMap<>();
        Set<String> visitados = new HashSet<>();
        PriorityQueue<String> filaPrioridade = new PriorityQueue<>(Comparator.comparingInt(distancia::get));

        // Inicialização
        for (String cidade : adjacencyList.keySet()) {
            distancia.put(cidade, Integer.MAX_VALUE);
            predecessores.put(cidade, null);
        }

        distancia.put(cidadeOrigem, 0);
        filaPrioridade.add(cidadeOrigem);

        while (!filaPrioridade.isEmpty()) {
            String cidadeAtual = filaPrioridade.poll();
            if (visitados.contains(cidadeAtual)) {
                continue;
            }

            visitados.add(cidadeAtual);

            for (Map.Entry<String, Integer> vizinho : adjacencyList.get(cidadeAtual).entrySet()) {
                String cidadeVizinho = vizinho.getKey();
                int pesoAresta = vizinho.getValue();

                int novaDistancia = distancia.get(cidadeAtual) + pesoAresta;

                if (novaDistancia < distancia.get(cidadeVizinho)) {
                    distancia.put(cidadeVizinho, novaDistancia);
                    predecessores.put(cidadeVizinho, cidadeAtual);
                    filaPrioridade.add(cidadeVizinho);
                }
            }
        }

        int distanciaTotal = distancia.get(cidadeDestino);

        // Reconstruir o caminho mais curto
        List<String> caminho = new ArrayList<>();
        String cidadeAtual = cidadeDestino;

        while (cidadeAtual != null) {
            caminho.add(cidadeAtual);
            cidadeAtual = predecessores.get(cidadeAtual);
        }

        Collections.reverse(caminho);
        return new CaminhoMaisCurto(caminho, distanciaTotal);
    }

    // public static void main(String[] args) {
    //     GrafoCidades grafo = new GrafoCidades();

    //     // Adicionar cidades
    //     grafo.adicionarCidade("Luanda");
    //     grafo.adicionarCidade("Talatona");
    //     grafo.adicionarCidade("Viana");
    //     grafo.adicionarCidade("Cacuaco");

    //     // Adicionar estradas
    //     grafo.adicionarEstrada("Luanda", "Talatona", 25);
    //     grafo.adicionarEstrada("Luanda", "Cacuaco", 15);
    //     grafo.adicionarEstrada("Luanda", "Viana", 20);
    //     grafo.adicionarEstrada("Viana", "Cacuaco", 10);

    //     // Imprimir informações

    //     // Encontrar o caminho mais curto entre Luanda e Talatona
    //     GrafoCidades.CaminhoMaisCurto caminhoMaisCurto = grafo.caminhoMaisCurto("Talatona", "Viana");
    //     exibirMensagem("Caminho mais curto: " + caminhoMaisCurto.getCaminho() + "\nDistância total: " + caminhoMaisCurto.getDistanciaTotal() + " km");
    // }

    public void imprimirCidades() {
        exibirMensagem("Cidades no grafo:\n" + String.join("\n", adjacencyList.keySet()));
    }

    public void imprimirEstradas() {
        exibirMensagem("\nEstradas no grafo:");
        for (Map.Entry<String, Map<String, Integer>> entry : adjacencyList.entrySet()) {
            String cidadeOrigem = entry.getKey();
            Map<String, Integer> destinos = entry.getValue();

            for (Map.Entry<String, Integer> destino : destinos.entrySet()) {
                String cidadeDestino = destino.getKey();
                int quilometros = destino.getValue();
                exibirMensagem(cidadeOrigem + " -> " + cidadeDestino + ": " + quilometros + " km");
            }
        }
    }

    private static void exibirMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }
}
