package com.desafio.tecnico.supera.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class MatrizCaracolService {

    private static final Logger LOGGER = Logger.getLogger(MatrizCaracolService.class.getName());

    // Converte o Map<String, String> em uma matriz de inteiros
    public int[][] converterStringParaMatriz(Map<String, String> matrizInput) {
        try {
            int tamanho = (int) Math.sqrt(matrizInput.size());
            int[][] matriz = new int[tamanho][tamanho];

            for (int i = 0; i < tamanho; i++) {
                for (int j = 0; j < tamanho; j++) {
                    String key = "matriz[" + i + "][" + j + "]";
                    String value = matrizInput.get(key);

                    // Verifica se o valor existe e está correto
                    if (value != null) {
                        try {
                            matriz[i][j] = Integer.parseInt(value);
                        } catch (NumberFormatException e) {
                            LOGGER.log(Level.SEVERE, "Erro de conversão de String para Integer: " + value, e);
                            throw new IllegalArgumentException("Valor inválido no campo: " + key);
                        }
                    } else {
                        throw new IllegalArgumentException("Campo ausente: " + key);
                    }
                }
            }

            return matriz;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao converter o mapa para matriz.", e);
            throw new IllegalArgumentException("Erro ao processar a matriz.");
        }
    }

    // Processa a matriz em forma de caracol
    public List<Integer> percorrerMatrizCaracol(int[][] matriz) {
        List<Integer> resultado = new ArrayList<>();

        if (matriz == null || matriz.length == 0 || matriz[0].length == 0) {
            return resultado;
        }

        int linhas = matriz.length;
        int colunas = matriz[0].length;

        int cima = 0, baixo = linhas - 1;
        int esquerda = 0, direita = colunas - 1;

        while (cima <= baixo && esquerda <= direita) {
            for (int i = esquerda; i <= direita; i++) {
                resultado.add(matriz[cima][i]);
            }
            cima++;

            for (int i = cima; i <= baixo; i++) {
                resultado.add(matriz[i][direita]);
            }
            direita--;

            if (cima <= baixo) {
                for (int i = direita; i >= esquerda; i--) {
                    resultado.add(matriz[baixo][i]);
                }
                baixo--;
            }

            if (esquerda <= direita) {
                for (int i = baixo; i >= cima; i--) {
                    resultado.add(matriz[i][esquerda]);
                }
                esquerda++;
            }
        }

        return resultado;
    }
}
