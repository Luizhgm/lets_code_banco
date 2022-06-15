package Model;

import Enums.TipoConta;

public class ContaCorrente extends Conta{

    private double limite = 0;

    public ContaCorrente(Agencia agencia, Cliente cliente) {
        super(agencia, cliente, TipoConta.CONTA_CORRENTE);
        this.limite=0.0;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }


    @Override
    public void transferencia(Conta conta, double Valor) throws Exception {
        if (conta==null){
            throw new Exception("Conta não existe");
        }
        else if (this.getSaldo()+this.getLimite()<Valor){
            throw new Exception("Saldo+limite insuficiente");
        }

        this.setSaldo(this.getSaldo()-Valor);
        conta.setSaldo(conta.getSaldo()+Valor);
    }

    @Override
    public void saque(double Valor) throws Exception {
        if (this.getSaldo()+this.getLimite()<Valor){
            throw new Exception("Saldo+limite insuficiente");
        }
        this.setSaldo(this.getSaldo()-Valor);

    }

    @Override
    public void deposito(double Valor) {
        this.setSaldo(this.getSaldo()+Valor);
    }

    @Override
    public void remuneracao() {
        //IPCA em porcentagem (/100) e diario (/365)
        double taxa = (1+(MacroEconomia.getInstance().getIPCA())/365/100);
        this.setSaldo(this.getSaldo()*taxa);
    }

    @Override
    public String printContaDetalhada() {
        return "Conta do tipo: "+this.getTipoConta()+ "\n"+
                this.getCliente().printCliente()+
                "Conta de numero: "+this.getNumero()+ "\n"+
                "Agencia numero: "+this.getAgencia().getNumero()+ "\n"+
                "Limite: "+this.limite+ "\n"+
                "Saldo: "+this.getSaldo();
    }


}
