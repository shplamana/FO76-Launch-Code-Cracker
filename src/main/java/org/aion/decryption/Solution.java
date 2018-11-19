package org.aion.decryption;

public class Solution {

    private String encoded;
    private String decoded;
    private String codeword;

    public Solution() {
    }

    public Solution(String encoded, String decoded, String codeword) {
        this.encoded = encoded;
        this.decoded = decoded;
        this.codeword = codeword;
    }

    public String getEncoded() {
        return encoded;
    }

    public void setEncoded(String encoded) {
        this.encoded = encoded;
    }

    public Solution withEncoded(String encoded) {
        this.encoded = encoded;
        return this;
    }

    public String getDecoded() {
        return decoded;
    }

    public void setDecoded(String decoded) {
        this.decoded = decoded;
    }

    public Solution withDecoded(String decoded) {
        this.decoded = decoded;
        return this;
    }

    public String getCodeword() {
        return codeword;
    }

    public void setCodeword(String codeword) {
        this.codeword = codeword;
    }

    public Solution withCodeword(String codeword) {
        this.codeword = codeword;
        return this;
    }

}
