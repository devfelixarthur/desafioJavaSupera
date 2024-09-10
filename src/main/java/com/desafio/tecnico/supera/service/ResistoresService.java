package com.desafio.tecnico.supera.service;

import com.desafio.tecnico.supera.enums.ResistorColor;
import com.desafio.tecnico.supera.exceptions.ResistorInvalidoException;
import com.desafio.tecnico.supera.model.ResistorModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResistoresService {

    public ResistorModel converterOhmsParaResistor(String entrada) {
        if (!entrada.endsWith(" ohms")) {
            throw new ResistorInvalidoException("Entrada inválida! Certifique-se de que a unidade é 'ohms'.");
        }

        String valorSemOhms = entrada.replace(" ohms", "").trim();
        List<ResistorColor> bandasDeCores = new ArrayList<>();
        int multiplicador = 0;

        if (valorSemOhms.endsWith("k")) {
            valorSemOhms = valorSemOhms.replace("k", "");
            multiplicador = 2;
        } else if (valorSemOhms.endsWith("M")) {
            valorSemOhms = valorSemOhms.replace("M", "");
            multiplicador = 5;
        }

        try {
            double valor = Double.parseDouble(valorSemOhms);

            if (valor < 0.1 || valor > 999) {
                throw new ResistorInvalidoException("Valor fora do intervalo permitido. Deve estar entre 0.1 e 999.");
            }

            if (multiplicador == 0) {
                if (valor >= 100) {
                    multiplicador = 1;
                } else {
                    multiplicador = 0;
                }
            }

            String valorStr = String.format("%.0f", valor);
            int primeiroDigito = Character.getNumericValue(valorStr.charAt(0));
            int segundoDigito = (valorStr.length() > 1) ? Character.getNumericValue(valorStr.charAt(1)) : 0;

            bandasDeCores.add(ResistorColor.getColorByValue(primeiroDigito));
            bandasDeCores.add(ResistorColor.getColorByValue(segundoDigito));
            bandasDeCores.add(ResistorColor.getColorByValue(multiplicador));

            return new ResistorModel(entrada, bandasDeCores, ResistorColor.DOURADO.getColor());

        } catch (NumberFormatException e) {
            throw new ResistorInvalidoException("Formato de entrada inválido. Certifique-se de que o valor é numérico.");
        }
    }
}
