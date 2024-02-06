package ir.digipay.digiwallet.service;

import ir.digipay.digiwallet.model.Transaction;
import ir.digipay.digiwallet.repository.TransactionRepository;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.*;


public class AdminWalletService extends WalletService {
    public AdminWalletService(TransactionRepository transactionRepository) {
        super(transactionRepository);
    }

    public List<Transaction> getTransactions(Predicate<Transaction> predicate) {
        return transactionRepository.getAll().stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.getAll();
    }
}
