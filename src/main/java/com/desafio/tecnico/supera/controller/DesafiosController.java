package com.desafio.tecnico.supera.controller;

import com.desafio.tecnico.supera.exceptions.ResistorInvalidoException;
import com.desafio.tecnico.supera.model.ResistorModel;
import com.desafio.tecnico.supera.service.MatrizCaracolService;
import com.desafio.tecnico.supera.service.ResistoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


@Controller
public class DesafiosController {

    @Autowired
    ResistoresService resistoresService;

    @Autowired
    MatrizCaracolService matrizCaracolService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/desafioResistor")
    public String form() {
        return "resistores";
    }

    @PostMapping("/converter")
    public String converterResistor(@RequestParam("valorOhms") String valorOhms, Model model) {
        try {
            ResistorModel resultado = resistoresService.converterOhmsParaResistor(valorOhms);
            model.addAttribute("resultado", resultado);
        } catch (ResistorInvalidoException e) {
            model.addAttribute("errorMessage", e.getMessage());
        }
        return "resistores";
    }

    @GetMapping("/desafioSnail")
    public String formMatrizCaracol() {
        return "snail";
    }

    @PostMapping("/caracol")
    public String processarMatriz(@RequestParam Map<String, String> matrizInput, Model model) {
        try {
            int[][] matriz = matrizCaracolService.converterStringParaMatriz(matrizInput);

            model.addAttribute("resultado", matrizCaracolService.percorrerMatrizCaracol(matriz));
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Erro ao processar a matriz. Verifique se o formato está correto.");
        }
        return "snail";
    }


}
