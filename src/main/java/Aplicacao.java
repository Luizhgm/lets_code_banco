import Servicos.ServicoCliente;
import Servicos.ServicoConta;
import presentation.frames.Clientes;
import presentation.frames.Contas;
import presentation.frames.Home;
import presentation.frames.clientes.CadastrarCliente;
import presentation.frames.clientes.CadastrarClientePF;
import presentation.frames.clientes.CadastrarClientePJ;
import presentation.frames.clientes.ListarClientes;
import presentation.frames.contas.*;
import presentation.navigation.Navigator;

import java.util.Scanner;

public class Aplicacao {
    public static void main(String[] args) {

        Navigator navigator = new Navigator();
        navigator.addFrame("home", Home.class);
        navigator.addFrame("clientes", Clientes.class);
        navigator.addFrame("contas", Contas.class);
        navigator.addFrame("cadastrar-cliente", CadastrarCliente.class);
        navigator.addFrame("listar-clientes", ListarClientes.class);
        navigator.addFrame("cadastrar-cliente-pf", CadastrarClientePF.class);
        navigator.addFrame("cadastrar-cliente-pj", CadastrarClientePJ.class);
        navigator.addFrame("abrir-conta", AbrirConta.class);
        navigator.addFrame("abrir-conta-poupanca", AbrirContaPoupanca.class);
        navigator.addFrame("abrir-conta-corrente", AbrirContaCorrente.class);
        navigator.addFrame("abrir-conta-investimento", AbrirContaInvestimento.class);
        navigator.addFrame("acessar-conta", AcessarConta.class);
        navigator.addFrame("listar-contas", ListarContas.class);
        navigator.addFrame("detalhes-conta", DetalhesConta.class);
        navigator.addFrame("transferir", Transferir.class);
        navigator.addFrame("sacar", Sacar.class);
        navigator.addFrame("depositar", Depositar.class);
        navigator.addFrame("investir", Investir.class);
        navigator.init("home");
        while(!navigator.isEmpty()) {
            navigator.renderCurrentFrame();
        }
        new Scanner(System.in).close();
        System.exit(0);
    }
}
