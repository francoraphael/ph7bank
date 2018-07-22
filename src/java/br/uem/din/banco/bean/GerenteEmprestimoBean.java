package br.uem.din.banco.bean;

import br.uem.din.banco.controller.EmprestimoController;
import br.uem.din.banco.model.Emprestimo;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@Named(value = "gerenteEmprestimoBean")
@SessionScoped
public class GerenteEmprestimoBean implements Serializable {

    public GerenteEmprestimoBean() {
    }

    public void aceitarEmprestimo(Emprestimo emprestimo) {
        EmprestimoController.getInstance().aceitarEmprestimo(emprestimo);
    }

    public void rejeitarEmprestimo(Emprestimo emprestimo) {
        EmprestimoController.getInstance().rejeitarEmprestimo(emprestimo);
    }

}
