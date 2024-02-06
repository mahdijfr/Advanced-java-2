package ir.digipay.digiwallet;

import ir.digipay.digiwallet.model.*;
import ir.digipay.digiwallet.repository.*;
import ir.digipay.digiwallet.service.WalletService;

import java.math.BigDecimal;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        TransactionRepository transactionRepository = new TransactionRepositoryImpl();
        WalletService walletService = new WalletService(transactionRepository);
        Wallet wallet = new Wallet("x-y-z");
        Transaction transaction = new Transaction(1, wallet, TransactionType.DEPOSIT, BigDecimal.valueOf(1000), new Date());
        System.out.println(walletService.addTransaction(transaction));
        walletService.setTransactionStatus(transaction, TransactionStatus.ACCEPTED);
        System.out.println(walletService.getBalance(wallet));
        System.out.println(walletService.getTransactions(wallet));
        System.out.println(walletService.getTransactions(wallet, t -> t.amount.equals(BigDecimal.valueOf(1000))));
    }
}
