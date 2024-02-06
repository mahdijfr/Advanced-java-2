package ir.digipay.digiwallet.model;

public class Wallet {
    public final String id;

    public Wallet(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "[" + "Id: " + id + "]";
    }
}
