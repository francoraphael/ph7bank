package br.uem.din.banco.bean;

import br.uem.din.banco.controller.CadastroController;
import br.uem.din.banco.model.Cliente;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@Named(value = "clienteCadastroBean")
@SessionScoped
public class ClienteCadastroBean implements Serializable {

    private String nome;
    private String cpf;
    private String datanascimento;
    private String senha;
    private int tipoconta;

    public ClienteCadastroBean() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(String datanascimento) {
        this.datanascimento = datanascimento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getTipoconta() {
        return tipoconta;
    }

    public void setTipoconta(int tipoconta) {
        this.tipoconta = tipoconta;
    }

    public void cadastrar() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) contexto.getExternalContext().getSession(false);
        CadastroController.getInstance().salvarCliente(new Cliente(nome, senha, datanascimento, cpf, tipoconta));
        try {
            contexto.getExternalContext().redirect("login.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(ClienteCadastroBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void remover(Cliente cliente){
        System.out.print(cliente.getNome());
        CadastroController.getInstance().removerCliente(cliente);
    }

}
