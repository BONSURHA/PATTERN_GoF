package it.unipv.ingsfw.patterns.singleton;

import it.unipv.ingsfw.patterns.adapter.usdollar.USDollarAdapter;
import it.unipv.ingsfw.patterns.adapter.usdollar.USDollarWallet;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.util.Properties;

public class WalletFactorySingleton {
    private static WalletFactorySingleton instance = null;
    private static USDollarAdapter usDollarAdapter;
    private static final String US_PROPRERTYNAME = "usdollar.adapter.class.name";

    private WalletFactorySingleton() {
        super();
    }

    public static WalletFactorySingleton getInstance (){
        if(instance == null){
            instance = new WalletFactorySingleton();
            System.out.println("instance created");
        }else{
            System.out.println("instance already existed");
        }
        return instance;
    }

    public static USDollarAdapter getUsDollarAdapter(USDollarWallet usDollarWallet) {
        if (usDollarAdapter == null) {
            String USDollarAdaptClassName;
            try {
                Properties p = new Properties(System.getProperties());
                p.load(new FileInputStream("properties/properties"));
                USDollarAdaptClassName = p.getProperty(US_PROPRERTYNAME);

                // TODO JAVA REFLECTION
                Constructor c = Class.forName(USDollarAdaptClassName).getConstructor(USDollarWallet.class);
                usDollarAdapter = (USDollarAdapter) c.newInstance(usDollarWallet);

            } catch (Exception e) {
                e.getStackTrace();
            }
        }
        return usDollarAdapter;
    }
}
