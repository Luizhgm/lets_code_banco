package Model;

public class MacroEconomia {
    private static MacroEconomia  Economia;

    private double CDI;
    private double IPCA;

    private MacroEconomia() {
    }

    public static synchronized MacroEconomia getInstance() {
        if (Economia == null)
            Economia = new MacroEconomia();

        return Economia;
    }


    public double getCDI() {
        return CDI;
    }

    public void setCDI(double CDI) {
        this.CDI = CDI;
    }

    public double getIPCA() {
        return IPCA;
    }

    public void setIPCA(double IPCA) {
        this.IPCA = IPCA;
    }

}

