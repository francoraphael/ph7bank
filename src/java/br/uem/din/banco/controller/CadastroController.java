package br.uem.din.banco.controller;

import br.uem.din.banco.model.Cliente;
import java.util.ArrayList;
import java.util.List;

public class CadastroController {

    private static List<Cliente> clientes;

    private static CadastroController instance;

    private CadastroController() {
        this.clientes = new ArrayList<>();
    }

    public static CadastroController getInstance() {
        if (instance == null) {
            instance = new CadastroController();
        }
        return instance;
    }

    public void salvarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public List<Cliente> listarClientes() {
        return clientes;
    }

    public void removerCliente(Cliente cliente) {
        this.clientes.remove(cliente);
    }

    public Cliente retornaClienteCpf(String cpf) {
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) {
                return c;
            }
        }
        return null;
    }

    public Cliente retornaClienteAC(int agencia, int numeroconta) {
        for (Cliente c : clientes) {
            if (c.getConta().getAgencia() == agencia) {
                if (c.getConta().getNumeroconta() == numeroconta) {
                    return c;
                }
            }
        }
        return null;
    }

    public Cliente retornaClienteEI(int id) {
        for (Cliente c : clientes) {
            if (c.getTipoconta() == 2) {
                if (c.getConta().getEmprestimo().getId() == id) {
                    return c;
                }
            }
        }
        return null;
    }

    public static boolean ehCliente(String cpf, String senha) {
        CadastroController.getInstance();
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) {
                if (c.getSenha().equals(senha)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String getNome(String cpf) {
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) {
                return c.getNome();
            }
        }
        return null;
    }
}
