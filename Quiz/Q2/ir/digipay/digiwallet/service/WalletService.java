package ir.digipay.digiwallet.service;

import ir.digipay.digiwallet.model.*;
import ir.digipay.digiwallet.repository.TransactionRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.*;


public class WalletService {
    protected final TransactionRepository transactionRepository;

    public WalletService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public boolean addTransaction(Transaction transaction) throws IllegalArgumentException {
        return transactionRepository.add(transaction);
    }

    public List<Transaction> getTransactions(Wallet wallet) {
        return transactionRepository.getAll().stream()
                    .filter((t) -> t.wallet.id.equals(wallet.id))
                    .collect(Collectors.toList());
    }

    public List<Transaction> getTransactions(Wallet wallet, Predicate<Transaction> predicate) {
        return transactionRepository.getAll().stream()
                    .filter((t) -> t.wallet.id.equals(wallet.id))
                    .filter(predicate)
                    .collect(Collectors.toList());
    }

    public BigDecimal getBalance(Wallet wallet) {
        List<Transaction> transactions = getTransactions(wallet, (t) -> t.getStatus() == TransactionStatus.ACCEPTED);

        return  transactions.stream()
                        .filter((t) -> t.type == TransactionType.DEPOSIT)
                        .map(t -> t.amount)
                        .reduce(BigDecimal.ZERO, BigDecimal::add)
                .subtract(
                    transactions.stream()
                    .filter((t) -> t.type == TransactionType.WITHDRAWAL)
                    .map(t -> t.amount)
                    .reduce(BigDecimal.ZERO, BigDecimal::add)
                );
    }

    public boolean setTransactionStatus(Transaction transaction, TransactionStatus status) {
        if (transaction.getStatus() != TransactionStatus.PENDING || status == TransactionStatus.PENDING) {
            return false;
        }
        else if (transaction.type == TransactionType.WITHDRAWAL && getBalance(transaction.wallet).compareTo(transaction.amount) < 0) {
            throw new IllegalArgumentException();
        }
    
        transaction.setStatus(status);
        return true;
    }
}
