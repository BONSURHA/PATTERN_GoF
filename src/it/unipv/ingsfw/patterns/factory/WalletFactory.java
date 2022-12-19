package it.unipv.ingsfw.patterns.factory;

import it.unipv.ingsfw.patterns.adapter.EUWallet;
import it.unipv.ingsfw.patterns.adapter.tester.Pay;
import it.unipv.ingsfw.patterns.adapter.usdollar.USDollarAdapter;
import it.unipv.ingsfw.patterns.adapter.usdollar.USDollarWallet;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.util.Properties;

public class WalletFactory {
    private static USDollarAdapter usDollarAdapter;
    private static final String US_PROPRERTYNAME = "usdollar.adapter.class.name";

    public static USDollarAdapter getUsDollarAdapter(USDollarWallet usDollarWallet){
        if(usDollarAdapter==null){
            String USDollarAdaptClassName;
            try{
                Properties p = new Properties(System.getProperties());
                p.load(new FileInputStream("properties/properties"));
                USDollarAdaptClassName = p.getProperty(US_PROPRERTYNAME);

                // TODO JAVA REFLECTION
                Constructor c = Class.forName(USDollarAdaptClassName).getConstructor(USDollarWallet.class);
                usDollarAdapter=(USDollarAdapter) c.newInstance(usDollarWallet);

            }catch(Exception e){
                e.getStackTrace();
            }
        }

        return usDollarAdapter;
    }

    public static void main(String[] args){
        EUWallet eu = new EUWallet(300);
        USDollarWallet us = new USDollarWallet(300);

        Pay pay = new Pay();

        pay.addWallet(eu);
        pay.addWallet(WalletFactory.getUsDollarAdapter(us));

        pay.prelievo(25);


    }
}
