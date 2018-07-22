package br.uem.din.banco.controller;
import br.uem.din.banco.model.Gerente;

public class GerenteController {
     private static Gerente gerente = new Gerente("Raphael Franco", "admin", "16/05/1998", "327.213.138-86");
    
    public GerenteController(){
    }
    
    public static Boolean ehGerente(String cpf, String senha){
        if(gerente.getCpf().equals(cpf)){
            if(gerente.getSenha().equals(senha)){
                return true;
            }
        }
        return false;
    }
    
    public static String getNome(){
        return gerente.getNome();
    }
}
