package br.uem.din.banco.controller;

import br.uem.din.banco.model.Cliente;

public class TransacoesController {

    private static Cliente destinatario;

    public static void transferirValor(int agencia, int numeroconta, double valor, Cliente cliente) {
        destinatario = CadastroController.getInstance().retornaClienteAC(agencia, numeroconta);
        if(destinatario != null){
            if(cliente.getConta().sacarValor(valor)){
                destinatario.getConta().depositarValor(valor);
            }
        }
    }
}
