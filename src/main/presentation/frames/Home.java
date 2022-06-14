package presentation.frames;

import presentation.navigation.Frame;
import presentation.navigation.Navigator;

public class Home extends Frame {
    public Home(String key, Navigator navigator) {
        super(key, navigator);
    }

    @Override
    public void render() throws Exception {
        printFrameTitle("INÍCIO");
        System.out.println("1. Clientes");
        System.out.println("2. Contas");
        System.out.println("3. Encerrar");
        System.out.println();

        System.out.print("Digite a opção desejada: ");

        int option = this.scanner.nextInt();
        this.scanner.nextLine();

        switch (option) {
            case 1:
                navigator.navigate("clientes");
                break;
            case 2:
                navigator.navigate("contas");
                break;
            case 3:
                System.exit(0);
                break;
            default:
                throw new Exception("Opção invalida!");
        }
    }
}
