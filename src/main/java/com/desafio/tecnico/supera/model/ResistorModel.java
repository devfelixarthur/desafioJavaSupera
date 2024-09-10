package com.desafio.tecnico.supera.model;

import com.desafio.tecnico.supera.enums.ResistorColor;

import java.util.List;
import java.util.stream.Collectors;


public class ResistorModel {
    private String valorOhms;
    private List<ResistorColor> bandasDeCores;
    private String tolerancia;

    public ResistorModel(String valorOhms, List<ResistorColor> bandasDeCores, String tolerancia) {
        this.valorOhms = valorOhms;
        this.bandasDeCores = bandasDeCores;
        this.tolerancia = tolerancia;
    }

    public ResistorModel() {
    }

    public String getValorOhms() {
        return valorOhms;
    }

    public void setValorOhms(String valorOhms) {
        this.valorOhms = valorOhms;
    }

    public List<ResistorColor> getBandasDeCores() {
        return bandasDeCores;
    }

    public void setBandasDeCores(List<ResistorColor> bandasDeCores) {
        this.bandasDeCores = bandasDeCores;
    }

    public String getTolerancia() {
        return tolerancia;
    }

    public void setTolerancia(String tolerancia) {
        this.tolerancia = tolerancia;
    }

    public String obterDescricaoCores() {
        String coresBandas = bandasDeCores.stream()
                .map(ResistorColor::getColor)
                .collect(Collectors.joining(" "));

        return coresBandas + " " + tolerancia;
    }
}
