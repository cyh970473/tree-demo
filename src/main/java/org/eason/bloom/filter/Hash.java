package org.eason.bloom.filter;

class Hash {
    private int num;

    public Hash(int num) {
        this.num = num;
    }

    public int hash(String str) {
        int hash = str.length();
        for (int i = 0; i < str.length(); i++) {
            hash += str.charAt(i);
        }
        return hash + this.num;
    }
}
