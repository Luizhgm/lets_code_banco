import Enums.TipoConta;
import Model.*;
import Servicos.ServicoCliente;
import Servicos.ServicoConta;

public class ContaServer {
    public static void main(String[] args) throws Exception {

        ServicoCliente servicoCliente = ServicoCliente.getInstance();
        ServicoConta servicoConta = ServicoConta.getInstance();
        MacroEconomia macroEconomia = MacroEconomia.getInstance();
        macroEconomia.setCDI(10);
        macroEconomia.setIPCA(6);


        Agencia agencia = new Agencia("001", "001");


        Cliente cliente1 = ClienteServer.criarPessoasFisica(servicoCliente);
        Cliente cliente2 = ClienteServer.criarPessoasJuridica(servicoCliente);

        // abrir contas PF
        Conta cc1 = servicoConta.abrirConta(TipoConta.CONTA_CORRENTE, agencia, cliente1);
        Conta pou1 = servicoConta.abrirConta(TipoConta.CONTA_POUPANCA, agencia, cliente1);
        Conta inv1 = servicoConta.abrirConta(TipoConta.CONTA_INVESTIMENTO, agencia, cliente1);

        // abrir contas PJ (poupança não vale)
        Conta cc2 = servicoConta.abrirConta(TipoConta.CONTA_CORRENTE, agencia, cliente2);
        try{
            Conta pou2 = servicoConta.abrirConta(TipoConta.CONTA_POUPANCA, agencia, cliente2);
        }catch (Exception e) {
            if (e.getMessage().equals("Não pode abrir conta")) {
                System.out.println("REALMENTE NÃO PODE");
            }
        }

        Conta inv2 = servicoConta.abrirConta(TipoConta.CONTA_INVESTIMENTO, agencia, cliente2);
        listarContas(servicoConta);

        try{
            servicoConta.ConsultarConta("1234", agencia.getNumero());
        }catch (Exception e) {
            if (e.getMessage().equals("Conta não existe")) {
                System.out.println("REALMENTE NÃO EXISTIA");
            }
        }


        Conta conta;
        servicoConta.Depositar(cc1, 100);
        servicoConta.MudarLimite(cc1, 100);
        conta=servicoConta.ConsultarConta(cc1.getNumero(), agencia.getNumero());
        System.out.println("consultar conta de numero: "+cc1.getNumero()+" pós deposito de 100 reais e limite de 100 reais");
        System.out.println(conta.printContaDetalhada()+"\n");

        servicoConta.Depositar(pou1, 100);
        System.out.println("consultar conta de numero: "+pou1.getNumero()+" pós deposito de 100 reais");
        conta=servicoConta.ConsultarConta(pou1.getNumero(), agencia.getNumero());
        System.out.println(conta.printContaDetalhada()+"\n");


        servicoConta.Depositar(inv1, 200);
        servicoConta.Investir(inv1, 100);
        System.out.println("consultar conta de numero: "+inv1.getNumero()+" pós deposito de 200 reais e investir 100");
        conta=servicoConta.ConsultarConta(inv1.getNumero(), agencia.getNumero());
        System.out.println(conta.printContaDetalhada()+"\n");

        servicoConta.Depositar(inv2, 200);
        servicoConta.Investir(inv2, 100);

        System.out.println("consultar conta de numero: "+inv2.getNumero()+" pós deposito de 200 reais e investir 100");
        conta=servicoConta.ConsultarConta(inv2.getNumero(), agencia.getNumero());
        System.out.println(conta.printContaDetalhada()+"\n");


        servicoConta.RenderContasInvestimento();
        servicoConta.RenderContasPoupanca();
        servicoConta.RenderContasCorrentes();

        System.out.println("A conta é remunerada com base no CDI de: "+ macroEconomia.getCDI());
        System.out.println("A conta é remunerada com base no IPCA de: "+ macroEconomia.getIPCA());
        System.out.println("A remuneração da CC é de 100% do IPCA de forma diaria");
        System.out.println("A remuneração da poupança é de 100% do menor entre cdi/ipca de forma mensal");
        System.out.println("A remuneração da invetimento é de 100% do maior entre cdi/ipca de forma diaria + 2%anual se for juridica");
        System.out.println();

        System.out.println("consultar conta de numero: "+cc1.getNumero()+" pós rendimento");
        conta=servicoConta.ConsultarConta(cc1.getNumero(), agencia.getNumero());
        System.out.println(conta.printContaDetalhada()+"\n");

        System.out.println("consultar conta de numero: "+pou1.getNumero()+" pós rendimento");
        conta=servicoConta.ConsultarConta(pou1.getNumero(), agencia.getNumero());
        System.out.println(conta.printContaDetalhada()+"\n");

        System.out.println("consultar conta de numero: "+inv1.getNumero()+" pós rendimento");
        conta=servicoConta.ConsultarConta(inv1.getNumero(), agencia.getNumero());
        System.out.println(conta.printContaDetalhada()+"\n");

        System.out.println("consultar conta de numero: "+inv2.getNumero()+" pós rendimento");
        conta=servicoConta.ConsultarConta(inv2.getNumero(), agencia.getNumero());
        System.out.println(conta.printContaDetalhada()+"\n");



        servicoConta.Sacar(inv2, 100);
        System.out.println("consultar conta de numero: "+inv2.getNumero()+" sacando 100 reais");
        conta=servicoConta.ConsultarConta(inv2.getNumero(), agencia.getNumero());
        System.out.println(conta.printContaDetalhada()+"\n");

        servicoConta.Desinvestir(inv2, 100);
        System.out.println("consultar conta de numero: "+inv2.getNumero()+" desinvestido 100 reais");
        conta=servicoConta.ConsultarConta(inv2.getNumero(), agencia.getNumero());
        System.out.println(conta.printContaDetalhada()+"\n");

        servicoConta.Transferir(cc1, pou1, 100);
        System.out.println("Transferir 100 reais de: "+cc1.getNumero()+
                " para: "+pou1.getNumero());
        conta=servicoConta.ConsultarConta(cc1.getNumero(), agencia.getNumero());
        System.out.println(conta.printContaDetalhada()+"\n");
        conta=servicoConta.ConsultarConta(pou1.getNumero(), agencia.getNumero());
        System.out.println(conta.printContaDetalhada()+"\n");

        servicoConta.Transferir(cc1, pou1, 100);
        System.out.println("Transferir 100 reais de: "+cc1.getNumero()+
                " para: "+pou1.getNumero());
        conta=servicoConta.ConsultarConta(cc1.getNumero(), agencia.getNumero());
        System.out.println(conta.printContaDetalhada()+"\n");
        conta=servicoConta.ConsultarConta(pou1.getNumero(), agencia.getNumero());
        System.out.println(conta.printContaDetalhada()+"\n");

    }

    public static void listarContas(ServicoConta servicoConta){

        servicoConta.ListarContas();
        servicoConta.ListarContaCorrente();
        servicoConta.ListarContaPoupanca();
        servicoConta.ListarContaInvestimento();
    }
}
