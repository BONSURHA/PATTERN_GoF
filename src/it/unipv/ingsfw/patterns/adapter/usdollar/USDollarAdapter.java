package it.unipv.ingsfw.patterns.adapter.usdollar;

import it.unipv.ingsfw.patterns.adapter.EUWallet;
import it.unipv.ingsfw.patterns.adapter.IWallet;

public class USDollarAdapter implements IWallet {
    private USDollarWallet usDollarWallet;
    private static final double CONV = 1.06;

    public USDollarAdapter(USDollarWallet usDollarWallet) {
       this.usDollarWallet = usDollarWallet;
    }

    @Override
    public String prelievo(double value) {
        value = value*CONV;
        this.usDollarWallet.prelievo(value);
        return "rimanenti" + " "  + usDollarWallet.getUsDollar() + "$";
    }
}
