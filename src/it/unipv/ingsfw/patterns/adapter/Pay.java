package it.unipv.ingsfw.patterns.adapter;

import it.unipv.ingsfw.patterns.adapter.usdollar.USDollarAdapter;
import it.unipv.ingsfw.patterns.adapter.usdollar.USDollarWallet;

import java.util.ArrayList;
import java.util.List;

public class Pay {
    List<IWallet> wallet;

    public Pay() {
        this.wallet = new ArrayList<IWallet>();
    }

    public void addWallet(IWallet i) {
        this.wallet.add(i);
    }

    public void prelievo(double value){
        for(IWallet w: wallet){
            System.out.println( w.prelievo(value));
        }
    }

    public static void main (String[] args){
        EUWallet eu = new EUWallet(300);
        USDollarWallet us = new USDollarWallet(300);
        USDollarAdapter usAdapter = new USDollarAdapter(us);

        Pay pay = new Pay();

        pay.addWallet(eu);
        pay.addWallet(usAdapter);

        pay.prelievo(25);

    }
}
