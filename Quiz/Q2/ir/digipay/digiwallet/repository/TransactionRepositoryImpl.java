package ir.digipay.digiwallet.repository;

import ir.digipay.digiwallet.model.Transaction;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.*;


public class TransactionRepositoryImpl implements TransactionRepository {
    List<Transaction> transactions = new ArrayList<>();

    @Override
    public boolean add(Transaction transaction) throws IllegalArgumentException {
        if (transaction.amount.compareTo(BigDecimal.ZERO) <= 0 ) {

            throw new IllegalArgumentException();
        }
        else if (transactions.contains(transaction)) {
            return false;
        } else {
            transactions.add(transaction);
        }
    return true;
    }

    @Override
    public List<Transaction> getAll() {
        return transactions;
    }

    @Override
    public Transaction get(Long id) {
        return transactions.stream()
                        .filter(t -> t.id == id)
                        .findFirst()
                        .orElse(null);
    }

    @Override
    public List<Transaction> get(Predicate<Transaction> predicate) {
        return transactions.stream()
                        .filter(predicate)
                        .collect(Collectors.toList());
    }

}
