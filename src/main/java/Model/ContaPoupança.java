package Model;

import Enums.TipoConta;

public class ContaPoupança extends Conta{
    public ContaPoupança(Agencia agencia, Cliente cliente) {
        super(agencia, cliente, TipoConta.CONTA_POUPANCA);
    }

    @Override
    public void transferencia(Conta conta, double Valor) throws Exception {
        if (conta==null){
            throw new Exception("Conta não existe");
        }
        else if (this.getSaldo()<Valor){
            throw new Exception("Saldo insuficiente");
        }

        this.setSaldo(this.getSaldo()-Valor);
        conta.setSaldo(conta.getSaldo()+Valor);
    }

    @Override
    public void saque(double Valor) throws Exception {
        if (this.getSaldo()<Valor){
            throw new Exception("Saldo insuficiente");
        }
        this.setSaldo(this.getSaldo()-Valor);
    }

    @Override
    public void deposito(double Valor) {
        this.setSaldo(this.getSaldo()+Valor);

    }

    @Override
    public void remuneracao() {
        //CDI em porcentagem (/100) e mês (/12)
        double taxa = (1+(MacroEconomia.getInstance().getCDI()+2)/12/100);
        this.setSaldo(this.getSaldo()*taxa);
    }
}
