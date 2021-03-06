package presentation.frames.clientes;

import Servicos.ServicoCliente;
import presentation.navigation.Frame;
import presentation.navigation.Navigator;

public class ListarClientes extends Frame {

    public ListarClientes(String key, Navigator navigator) {
        super(key, navigator);
    }

    @Override
    public void render() {
        printFrameTitle("LISTAR CLIENTES");

        ServicoCliente servicoCliente=ServicoCliente.getInstance();

        servicoCliente.ListarClientes();

        System.out.println("Aperte ENTER para continuar...");

        if(this.scanner.hasNextLine()) {
            this.scanner.nextLine();
            navigator.goBack();
        }
    }
}
