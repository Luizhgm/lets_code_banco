package presentation.frames.contas;

import java.util.HashMap;

import Model.Agencia;
import Model.Conta;
import Servicos.ServicoCliente;
import Servicos.ServicoConta;
import presentation.navigation.Frame;
import presentation.navigation.Navigator;

public class AcessarConta extends Frame {
    private String codigoConta;

    public AcessarConta(String key, Navigator navigator) {
        super(key, navigator);
    }

    @Override
    public void render() throws Exception {
        printFrameTitle("ACESSAR CONTA");
        System.out.print("Digite o código da conta (deixe vazio para voltar): ");
        codigoConta = this.scanner.nextLine();

        if (codigoConta.isEmpty()) {
            this.navigator.goBack();
            return;
        }
        ServicoConta servicoConta = ServicoConta.getInstance();
        ServicoCliente servicoCliente = ServicoCliente.getInstance();
        Agencia agencia = servicoConta.getInstanceAgencia();

        Conta conta=servicoConta.ConsultarConta(codigoConta, agencia.getNumero());



        HashMap<String, Object> params = new HashMap<>();
        params.put("conta", conta);

        // navega para o frame "detalhes-conta" injetando os parametros
        this.navigator.navigate("detalhes-conta", params);
    }
    
}
