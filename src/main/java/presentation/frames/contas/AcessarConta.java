package presentation.frames.contas;

import java.util.HashMap;

import br.bb.Cliente;
import br.bb.ContaCorrente;
import br.bb.PessoaFisica;
import presentation.navigation.Frame;
import presentation.navigation.Navigator;

public class AcessarConta extends Frame {
    private String codigoConta;

    public AcessarConta(String key, Navigator navigator) {
        super(key, navigator);
    }

    @Override
    public void render() {
        printFrameTitle("ACESSAR CONTA");
        System.out.print("Digite o código da conta (deixe vazio para voltar): ");

        codigoConta = this.scanner.nextLine();

        if (codigoConta.isEmpty()) {
            this.navigator.goBack();
            return;
        }

        // TODO: implementar o lógica de acesso à conta

        // Conta de teste
        Cliente cliente = new PessoaFisica("fulano", "123.456.789-00");
        ContaCorrente conta = new ContaCorrente(cliente);

        // cria hash map para armazenar parametros de um frame
        HashMap<String, Object> params = new HashMap<>();
        params.put("conta", conta);

        // navega para o frame "detalhes-conta" injetando os parametros
        this.navigator.navigate("detalhes-conta", params);
    }
    
}
