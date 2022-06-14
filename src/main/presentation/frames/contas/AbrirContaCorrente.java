package presentation.frames.contas;

import presentation.navigation.Frame;
import presentation.navigation.Navigator;

public class AbrirContaCorrente extends Frame {
    public AbrirContaCorrente(String key, Navigator navigator) {
        super(key, navigator);
    }

    @Override
    public void render() {
        printFrameTitle("ABRIR CONTA CORRENTE");
        
        // TODO: implementar abertura de conta corrente

        System.out.println("Conta corrente aberta com sucesso!");
        System.out.println("Aperte ENTER para continuar...");

        if(this.scanner.hasNextLine()) {
            this.scanner.nextLine();
            navigator.goBack();
        }
    }
}
