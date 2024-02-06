package org.example;

public class CryptoConfig {
    private String algorithm;
    private String hexControlSum;
    private String stringFormat;
    private long step;
    public int processorCount;

    public CryptoConfig(String[] args) {
        if (args.length != 7 || !"myapp".equalsIgnoreCase(args[0])) {
            System.out.println("Недостаточно параметров.");
            return;
        }
        processorCount = Runtime.getRuntime().availableProcessors();
        for (int i = 1; i < args.length; i = i + 2) {
            ESettingType eType = ESettingType.getType(args[i]);
            switch (eType) {
                case ALGORITHM_NAME -> setAlgorithm(args[i + 1].toUpperCase());
                case HEX_CONTROL_SUM -> setHexControlSum(args[i + 1]);
                case CHAR_ARRAY_SIZE -> setStringSize(args[i + 1]);
            }
        }
    }

    private void setAlgorithm(String alg) {
        this.algorithm = Enum.valueOf(EHashType.class, alg).getText();
    }

    private void setHexControlSum(String controlSum) {
        this.hexControlSum = controlSum.trim().toUpperCase();
    }

    private void setStringSize(String stringSize) {
        this.stringFormat = "%" + stringSize + "s";
        final long combinationsNumber = (long) Math.pow(10, Integer.parseInt(stringSize));
        this.step = combinationsNumber / processorCount;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public String getHexControlSum() {
        return hexControlSum;
    }

    public String getStringFormat() {
        return stringFormat;
    }

    public long getStep() {
        return step;
    }

    public int getProcessorCount() {
        return processorCount;
    }
}
