package it.unipv.ingsfw.patterns.singleton;

public class SingletonClass {
    private static SingletonClass instance = null;


    private SingletonClass() {
        super();
    }

    public static SingletonClass getInstance(){
        if(instance == null) {
            instance = new SingletonClass();
            System.out.println("instance created");
        }else{
            System.out.println("instance already existed");
        }
        return instance;
    }

    public static void main(String[] args) {
        SingletonClass s = SingletonClass.getInstance();
        SingletonClass s1 = SingletonClass.getInstance();
    }




}
