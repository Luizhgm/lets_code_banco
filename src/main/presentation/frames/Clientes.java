package presentation.frames;

import presentation.navigation.Frame;
import presentation.navigation.Navigator;

public class Clientes extends Frame {
    public Clientes(String key, Navigator navigator) {
        super(key, navigator);
    }

    @Override
    public void render() {
        printFrameTitle("CLIENTES");
        System.out.println("1. Cadastrar cliente");
        System.out.println("2. Listar clientes");
        System.out.println("3. Voltar");
        System.out.println();

        System.out.print("Digite a opção desejada: ");

        int option = this.scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                navigator.navigate("cadastrar-cliente");
                break;
            case 2:
                navigator.navigate("listar-clientes");
                break;
            case 3:
                navigator.goBack();
                break;
            default:
                break;
        }
    }
    
}
