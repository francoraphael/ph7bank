package br.uem.din.banco.bean;

import java.io.IOException;
import br.uem.din.banco.controller.GerenteController;
import br.uem.din.banco.controller.CadastroController;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

@RequestScoped
@Named(value = "luser")
public class Login {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void login() {
        if (GerenteController.ehGerente(this.username, this.password)) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getSessionMap().put("user", GerenteController.getNome());
            context.getExternalContext().getSessionMap().put("cpf", username);
            try {
                context.getExternalContext().redirect("inicioGerente.xhtml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (CadastroController.ehCliente(this.username, this.password)) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getSessionMap().put("user", CadastroController.getNome(username));
            context.getExternalContext().getSessionMap().put("cpf", username);
            try {
                context.getExternalContext().redirect("inicioCliente.xhtml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().invalidateSession();
        try {
            context.getExternalContext().redirect("login.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
