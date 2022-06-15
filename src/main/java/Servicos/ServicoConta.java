package Servicos;

import Enums.TipoConta;
import Enums.TipoPessoa;
import Model.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Stream;

public class ServicoConta {
    private static ServicoConta  ServicoConta;
    private static Agencia agencia;

    private Map<String, Conta> contas = new HashMap<>();


    private ServicoConta() {
    }

    public static synchronized ServicoConta getInstance() {
        if (ServicoConta == null)
            ServicoConta = new ServicoConta();

        return ServicoConta;
    }

    public static synchronized Agencia getInstanceAgencia() {
        if (agencia == null)
            agencia = new Agencia("001", "001");

        return agencia;
    }


    public Conta abrirConta(TipoConta tipo, Agencia agencia, Cliente cliente) throws Exception {
        if (TipoConta.CONTA_INVESTIMENTO.equals(tipo)){
            ContaInvestimento conta = new ContaInvestimento(agencia, cliente);
            contas.put(conta.getCodigoConta(), conta);
            return conta;
        }
        else if (TipoConta.CONTA_POUPANCA.equals(tipo) &
                TipoPessoa.PESSOA_FISICA.equals(cliente.getPessoa().tipo)){
            ContaPoupança conta = new ContaPoupança(agencia, cliente);
            contas.put(conta.getCodigoConta(), conta);
            return conta;
        }
        else if (TipoConta.CONTA_CORRENTE.equals(tipo)){
            ContaCorrente conta = new ContaCorrente(agencia, cliente);
            contas.put(conta.getCodigoConta(), conta);
            return conta;
        }
        throw new Exception("Não pode abrir conta");
    }

    public void ListarContas(){
        Stream<Conta> cliente = contas.values().stream();

        // no futuro sorted no cliente;

        cliente.forEach(x->System.out.println(x.printConta()));

    };

    public void ListarContaCorrente(){
        Stream<Conta> cliente = contas.values().stream().filter(x->x.getTipoConta().equals(TipoConta.CONTA_CORRENTE));

        // no futuro sorted no cliente;

        cliente.forEach(x->System.out.println(x.printContaDetalhada()));

    };

    public void ListarContaPoupanca(){
        Stream<Conta> cliente = contas.values().stream().filter(x->x.getTipoConta().equals(TipoConta.CONTA_POUPANCA));

        // no futuro sorted no cliente;

        cliente.forEach(x->System.out.println(x.printContaDetalhada()));

    };

    public void ListarContaInvestimento(){
        Stream<Conta> cliente = contas.values().stream().filter(x->x.getTipoConta().equals(TipoConta.CONTA_INVESTIMENTO));

        // no futuro sorted no cliente;

        cliente.forEach(x->System.out.println(x.printContaDetalhada()));

    };


    public Conta ConsultarConta(String numero, String Agencia) throws Exception {
        Iterator<Conta> conta = contas.values().stream().filter(x->((x.getAgencia().getNumero().equals(Agencia)) & (x.getNumero().equals(numero)))).iterator();

        if (conta.hasNext()){
            Conta ContaAuxiliar = conta.next();
            ContaAuxiliar.printConta();
            return ContaAuxiliar;
        }

        throw new Exception("Conta não existe");

    }


    public void RenderContasInvestimento(){
        Iterator<Conta> conta = contas.values().stream().filter(x->x.getTipoConta().equals(TipoConta.CONTA_INVESTIMENTO)).iterator();
        while (conta.hasNext()){
            ((ContaInvestimento) conta.next()).remuneracao();
        }
    }

    public void RenderContasPoupanca(){
        Iterator<Conta> conta = contas.values().stream().filter(x->x.getTipoConta().equals(TipoConta.CONTA_POUPANCA)).iterator();
        while (conta.hasNext()){
            ((ContaPoupança) conta.next()).remuneracao();
        }
    }

    public void RenderContasCorrentes(){
        Iterator<Conta> conta = contas.values().stream().filter(x->x.getTipoConta().equals(TipoConta.CONTA_CORRENTE)).iterator();
        while (conta.hasNext()){
            ((ContaCorrente) conta.next()).remuneracao();
        }
    }

    public void Depositar(Conta conta, double valor){
        conta.deposito(valor);
    }

    public void MudarLimite(Conta conta, double valor) throws Exception {
        if (conta.getTipoConta().equals(TipoConta.CONTA_CORRENTE)){
            ((ContaCorrente) conta).setLimite(valor);
        }else{
            System.out.println("Não pode da limite para conta sem ser investimento");
        }

    }

    public void Investir(Conta conta, double valor) throws Exception {
        if (conta.getTipoConta().equals(TipoConta.CONTA_INVESTIMENTO)){
            ((ContaInvestimento) conta).investir(valor);
        }else{
            System.out.println("Não pode investir em conta diferente de investimento");
        }

    }

    public void Desinvestir(Conta conta, double valor) throws Exception {
        if (conta.getTipoConta().equals(TipoConta.CONTA_INVESTIMENTO)){
            ((ContaInvestimento) conta).desinvestir(valor);
        }else{
            System.out.println("Não pode Desinvestir em conta diferente de investimento");
        }

    }

    public void Sacar(Conta conta, double valor) throws Exception { conta.saque(valor); }
    public void Transferir(Conta conta, Conta contaAuxiliar, double valor) throws Exception { conta.transferencia(contaAuxiliar, valor); }



}