package br.uem.din.banco.bean;

import br.uem.din.banco.controller.CadastroController;
import br.uem.din.banco.controller.TransacoesController;
import br.uem.din.banco.controller.EmprestimoController;
import br.uem.din.banco.model.Emprestimo;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import br.uem.din.banco.model.Cliente;
import javax.faces.context.FacesContext;

@Named(value = "transacoes")
@SessionScoped
public class ClienteOperacoesBean implements Serializable {

    private double valor;
    private int agencia;
    private int numeroconta;
    private Cliente cliente;

    public ClienteOperacoesBean() {
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setNumeroconta(int numeroconta) {
        this.numeroconta = numeroconta;
    }

    public int getNumeroconta() {
        return numeroconta;
    }

    public String buscarContexto() {
        FacesContext context = FacesContext.getCurrentInstance();
        String cpf = (String) context.getExternalContext().getSessionMap().get("cpf");
        return cpf;
    }

    public void transferirValor() {
        String cpf = buscarContexto();
        cliente = CadastroController.getInstance().retornaClienteCpf(cpf);
        TransacoesController.transferirValor(agencia, numeroconta, valor, cliente);
    }

    public void depositarValor() {
        String cpf = buscarContexto();
        cliente = CadastroController.getInstance().retornaClienteCpf(cpf);
        cliente.getConta().depositarValor(getValor());
    }

    public void solicitarEmprestimo() {
        String cpf = buscarContexto();
        cliente = CadastroController.getInstance().retornaClienteCpf(cpf);
        EmprestimoController.getInstance().solicitarEmprestimo(cliente, valor);
    }

}
