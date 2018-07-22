package br.uem.din.banco.model;

import java.util.Random;

public class Emprestimo {

    private double valor;
    private int id;
    Random random = new Random();

    public double getValor() {
        return valor;
    }

    public int getId() {
        return id;
    }

    public Emprestimo(double valor) {
        this.id = 10000 + random.nextInt(90000);
        this.valor = valor;
    }
}
