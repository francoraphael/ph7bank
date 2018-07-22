package br.uem.din.banco.model;

public abstract class Pessoa {
    String nome;
    String senha;
    String datanascimento;
    String cpf;
    String id;

    public Pessoa(String nome, String senha, String datanascimento, String cpf) {
        this.nome = nome;
        this.senha = senha;
        this.datanascimento = datanascimento;
        this.cpf = cpf;
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getSenha() {
        return this.senha;
    }

    public String getDatanascimento() {
        return this.datanascimento;
    }

    public String getCpf() {
        return this.cpf;
    }

}
