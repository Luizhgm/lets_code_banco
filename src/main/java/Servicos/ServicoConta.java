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

    private Map<String, Conta> contas = new HashMap<>();


    private ServicoConta() {
    }

    public static synchronized ServicoConta getInstance() {
        if (ServicoConta == null)
            ServicoConta = new ServicoConta();

        return ServicoConta;
    }



    public Conta abrirConta(TipoConta tipo, Agencia agencia, Cliente cliente) throws Exception {
        if (TipoConta.CONTA_INVESTIMENTO.equals(tipo)){
            ContaInvestimento conta = new ContaInvestimento(agencia, cliente);
            contas.put(conta.getCodigoConta(), conta);
            return conta;
        }
        else if (TipoConta.CONTA_POUPANCA.equals(tipo) &
                TipoPessoa.PESSOA_FISICA.equals(cliente.pessoa.tipo)){
            ContaPoupança conta = new ContaPoupança(agencia, cliente);
            contas.put(conta.getCodigoConta(), conta);
            return conta;
        }
        else if (TipoConta.CONTA_CORRENTE.equals(tipo)){
            ContaCorrente conta = new ContaCorrente(agencia, cliente);
            contas.put(conta.getCodigoConta(), conta);
            return conta;
        }
        throw new Exception("Exception message");
    }

    public void ListarContas(){
        Stream<Conta> cliente = contas.values().stream();

        // no futuro sorted no cliente;

        cliente.forEach(x->System.out.println(x.printConta()));

    };

    public Conta ConsultarConta(String numero, String Agencia) throws Exception {
        Iterator<Conta> conta = contas.values().stream().filter(x->((x.getAgencia().equals(Agencia)) & (x.getNumero().equals(numero)))).iterator();

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
            ((ContaInvestimento) conta).remuneracao();
        }
    }

    public void RenderContasPoupanca(){
        Iterator<Conta> conta = contas.values().stream().filter(x->x.getTipoConta().equals(TipoConta.CONTA_POUPANCA)).iterator();
        while (conta.hasNext()){
            ((ContaPoupança) conta).remuneracao();
        }
    }

    public void RenderContasCorrentes(){
        Iterator<Conta> conta = contas.values().stream().filter(x->x.getTipoConta().equals(TipoConta.CONTA_CORRENTE)).iterator();
        while (conta.hasNext()){
            ((ContaCorrente) conta).remuneracao();
        }
    }

}