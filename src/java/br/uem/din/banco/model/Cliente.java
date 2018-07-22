package br.uem.din.banco.model;

public class Cliente extends Pessoa{

    private int tipoconta;
    private Conta conta;
    
    public Cliente(String nome, String senha, String datanascimento, String cpf, int tipoconta) {
        super(nome, senha, datanascimento, cpf);
        this.tipoconta = tipoconta;
        if(tipoconta == 1){
            conta = new ContaPoupanca();
        }else{
            conta = new ContaCorrente();
        }
    }
    
    public Conta getConta(){
        return conta;
    }
    
    public int getTipoconta(){
        return tipoconta;
    }
}
