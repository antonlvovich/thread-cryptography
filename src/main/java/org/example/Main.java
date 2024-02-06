package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CryptoMaster master = new CryptoMaster(new CryptoConfig(args));
        master.execute();
    }
}
