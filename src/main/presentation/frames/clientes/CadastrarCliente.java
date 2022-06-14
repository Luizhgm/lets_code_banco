package presentation.frames.clientes;

import presentation.navigation.Frame;
import presentation.navigation.Navigator;

public class CadastrarCliente extends Frame {
    public CadastrarCliente(String key, Navigator navigator) {
        super(key, navigator);
    }

    @Override
    public void render() {
        printFrameTitle("CADASTRAR CLIENTE");
        
        System.out.println("1. Cadastrar cliente PF");
        System.out.println("2. Cadastrar cliente PJ");
        System.out.println("3. Voltar");
        
        System.out.println();

        System.out.print("Digite a opção desejada: ");

        int option = scanner.nextInt();
        this.scanner.nextLine();

        switch (option) {
            case 1:
                navigator.navigate("cadastrar-cliente-pf");
                break;
            case 2:
                navigator.navigate("cadastrar-cliente-pj");
                break;
            case 3:
                navigator.goBack();
                break;
            default:
                break;
        }
    }
}
