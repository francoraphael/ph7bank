package br.uem.din.banco.controller;

import java.util.ArrayList;
import java.util.List;
import br.uem.din.banco.model.Emprestimo;
import br.uem.din.banco.model.Cliente;

public class EmprestimoController {
    private static List<Emprestimo> emprestimos;
    
    private static EmprestimoController instance;
    
    private EmprestimoController(){
        this.emprestimos = new ArrayList<>();
    }
    
    public static EmprestimoController getInstance(){
        if(instance == null){
            instance = new EmprestimoController();
        }
        return instance;
    }
    
    public void solicitarEmprestimo(Cliente cliente, double valor){
        if(cliente.getTipoconta() != 1){
            this.emprestimos.add(cliente.getConta().gerarEmprestimo(valor));
        }else{
        }
    }
    
    public List<Emprestimo> listarEmprestimos(){
        return emprestimos;
    }
    
    public void removerEmprestimo(Emprestimo emprestimo){
        this.emprestimos.remove(emprestimo);
    }
    
    public void aceitarEmprestimo(Emprestimo emprestimo){
        Cliente cliente = CadastroController.getInstance().retornaClienteEI(emprestimo.getId());
        cliente.getConta().depositarValor(emprestimo.getValor());
        removerEmprestimo(emprestimo);
    }
    
    public void rejeitarEmprestimo(Emprestimo emprestimo){
        removerEmprestimo(emprestimo);
    }
}
