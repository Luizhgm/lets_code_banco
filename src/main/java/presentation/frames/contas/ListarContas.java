package presentation.frames.contas;

import Servicos.ServicoConta;
import presentation.navigation.Frame;
import presentation.navigation.Navigator;

public class ListarContas extends Frame {

    public ListarContas(String key, Navigator navigator) {
        super(key, navigator);
    }

    @Override
    public void render() {
        printFrameTitle("LISTAR CONTAS");

        ServicoConta servicoConta = ServicoConta.getInstance();
        servicoConta.ListarContas();

        System.out.println("Aperte ENTER para continuar...");

        if(this.scanner.hasNextLine()) {
            this.scanner.nextLine();
            navigator.goBack();
        }
    }
}
