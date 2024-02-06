package org.example;

public enum EHashType {
    MD5("MD5"), SHA1("SHA-1");

    private final String text;

    EHashType(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
