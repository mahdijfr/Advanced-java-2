package ir.digipay.digiwallet.model;

import java.math.BigDecimal;
import java.util.Date;

public class Transaction {
    public final long id;
    public final Wallet wallet;
    public final TransactionType type;
    public final BigDecimal amount;
    private TransactionStatus status;
    public final Date createdAt;
    public Date updatedAt;

    public Transaction(long id, Wallet wallet, TransactionType type, BigDecimal amount, Date createdAt) {
        this.id = id;
        this.wallet = wallet;
        this.type = type;
        this.amount = amount;
        this.createdAt = createdAt;
        this.status = TransactionStatus.PENDING;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
        updatedAt = new Date();
    }

    @Override
    public String toString() {
        return String.format(
                "[Id: %d, Wallet Id: %s, Type: %s, Amount: %s, Status: %s]",
                id, wallet.id, type, amount, status
        );
    }
}
