package it.unipv.ingsfw.patterns.adapter.usdollar;

import it.unipv.ingsfw.patterns.adapter.IWallet;

public class USDollarWallet {
    private double usDollar;

    public USDollarWallet(double usDollar) {
        this.usDollar = usDollar;
    }

    public double getUsDollar() {
        return usDollar;
    }

    public void setUsDollar(double usDollar) {
        this.usDollar = usDollar;
    }

    public void prelievo(double value) {
        this.usDollar-=value;
    }
}
