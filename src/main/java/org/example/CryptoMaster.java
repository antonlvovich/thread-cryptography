package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CryptoMaster {
    private final CryptoConfig config;
    private final ExecutorService executorService;

    public CryptoMaster(CryptoConfig config) {
        this.config = config;
        this.executorService = Executors.newFixedThreadPool(this.config.getProcessorCount());
    }

    public void execute() throws InterruptedException {
        for (int i = 0; i < config.getProcessorCount(); i++)
            executorService.execute(new CryptoWorker(config, i));
        executorService.shutdown();
        if (!executorService.awaitTermination(45, TimeUnit.SECONDS))
            System.out.println("Время ожидания превышено");
    }
}