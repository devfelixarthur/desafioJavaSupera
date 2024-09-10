package com.desafio.tecnico.supera.enums;

public enum ResistorColor {
    PRETO(0, "preto"),
    MARROM(1, "marrom"),
    VERMELHO(2, "vermelho"),
    LARANJA(3, "laranja"),
    AMARELO(4, "amarelo"),
    VERDE(5, "verde"),
    AZUL(6, "azul"),
    VIOLETA(7, "violeta"),
    CINZA(8, "cinza"),
    BRANCO(9, "branco"),
    DOURADO(-1, "dourado");

    private final int value;
    private final String color;

    ResistorColor(int value, String color) {
        this.value = value;
        this.color = color;
    }

    public int getValue() {
        return value;
    }

    public String getColor() {
        return color;
    }

    public static ResistorColor getColorByValue(int value) {
        for (ResistorColor color : values()) {
            if (color.getValue() == value) {
                return color;
            }
        }
        throw new IllegalArgumentException("Valor inválido para resistor: " + value);
    }
}
