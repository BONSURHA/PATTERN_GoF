package it.unipv.ingsfw.patterns.singleton.test;

import it.unipv.ingsfw.patterns.adapter.EUWallet;
import it.unipv.ingsfw.patterns.adapter.Pay;
import it.unipv.ingsfw.patterns.adapter.usdollar.USDollarWallet;
import it.unipv.ingsfw.patterns.singleton.WalletFactorySingleton;

public class MainTest {
    public static void main(String[] args){
        WalletFactorySingleton s = WalletFactorySingleton.getInstance();
        WalletFactorySingleton s1 = WalletFactorySingleton.getInstance();
        EUWallet eu = new EUWallet(300);
        USDollarWallet us = new USDollarWallet(300);

        Pay pay = new Pay();

        pay.addWallet(eu);
        pay.addWallet(s.getUsDollarAdapter(us));

        pay.prelievo(25);
    }

}
