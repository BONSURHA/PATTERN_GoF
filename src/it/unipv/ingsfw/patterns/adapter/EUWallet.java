package it.unipv.ingsfw.patterns.adapter;

public class EUWallet implements  IWallet{
    private double euro;

    public EUWallet(double value) {
        this.euro = value;
    }

    public double getEuro() {
        return euro;
    }

    public String prelievo(double value) {
        this.euro-=value;
        return "rimanenti" + " "  + euro + "€";
    }
}
