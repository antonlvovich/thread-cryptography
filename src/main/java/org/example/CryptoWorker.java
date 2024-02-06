package org.example;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CryptoWorker implements Runnable {
    private final MessageDigest messageDigest;
    private final String hexChecksum;
    private final String stringFormat;
    private final long start;
    private final long max;

    public CryptoWorker(CryptoConfig config, int step) {
        try {
            messageDigest = MessageDigest.getInstance(config.getAlgorithm());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        this.hexChecksum = config.getHexControlSum();
        this.stringFormat = config.getStringFormat();
        this.start = step * config.getStep();
        this.max = (step + 1) * config.getStep();
    }

    @Override
    public void run() {
        byte[] digest;
        String temp_string;
        for (long min = start; min < max; min++) {
            temp_string = String.format(stringFormat, min).replace(' ', '0');
            digest = messageDigest.digest(temp_string.trim().getBytes(StandardCharsets.UTF_8));
            if (hexChecksum.equals(DatatypeConverter.printHexBinary(digest))) {
                System.out.println(min);
                break;
            }
        }
    }
}
