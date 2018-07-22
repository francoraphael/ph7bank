package br.uem.din.banco.bean;

import br.uem.din.banco.controller.CadastroController;
import br.uem.din.banco.controller.EmprestimoController;
import br.uem.din.banco.model.Cliente;
import br.uem.din.banco.model.Emprestimo;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.context.FacesContext;

@Named(value = "clienteListagemBean")
@SessionScoped
public class ClienteListagemBean implements Serializable {

    public ClienteListagemBean() {
    }

    public List<Cliente> getClientes() {
        return CadastroController.getInstance().listarClientes();
    }

    public Cliente getCliente() {
        FacesContext context = FacesContext.getCurrentInstance();
        String cpf = (String) context.getExternalContext().getSessionMap().get("cpf");
        return CadastroController.getInstance().retornaClienteCpf(cpf);
    }
    
    public List<Emprestimo> getEmprestimos(){
        return EmprestimoController.getInstance().listarEmprestimos();
    }
}
