package Model;

import Enums.TipoConta;

public class ContaInvestimento extends Conta {
    private double valorInvestido=0;


    public ContaInvestimento(Agencia agencia, Cliente cliente) {
        super(agencia, cliente, TipoConta.CONTA_INVESTIMENTO);
    }

    public double getValorInvestido() {
        return valorInvestido;
    }

    public void setValorInvestido(double valorInvestido) {
        this.valorInvestido = valorInvestido;
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
        //CDI+2 em porcentagem (/100) e diario (/365)
        double taxa = (1+(MacroEconomia.getInstance().getCDI()+2)/365/100);
        this.setValorInvestido(this.getValorInvestido()*taxa);
    }

    public void investir(double Valor) throws Exception {
        if (this.getSaldo()<Valor){
            throw new Exception("Saldo insuficiente");
        }
        this.setSaldo(this.getSaldo()-Valor);
        this.setValorInvestido(this.getValorInvestido()+Valor);

    }


}
