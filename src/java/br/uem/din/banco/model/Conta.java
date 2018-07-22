package br.uem.din.banco.model;

import java.util.Random;

public abstract class Conta {

    protected int numeroconta;
    protected int agencia;
    protected double saldo;
    protected Emprestimo emprestimo;
    Random random = new Random();

    public Conta() {
        this.saldo = 0;
        this.numeroconta = 10000000 + random.nextInt(900000000);
        this.agencia = 10000 + random.nextInt(90000);
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public long getNumeroconta() {
        return numeroconta;
    }

    public int getAgencia() {
        return agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean sacarValor(double valor) {
        if (this.saldo < valor) {
            return false;
        } else {
            this.saldo -= valor;
            return true;
        }
    }

    public void depositarValor(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("Valor de depósito negativo !");
        } else {
            this.saldo += valor;
        }
    }

    public Emprestimo gerarEmprestimo(double valor) {
        if (valor > 0) {
            emprestimo = new Emprestimo(valor);
            return emprestimo;
        } else {
            return null;
        }
    }
}
