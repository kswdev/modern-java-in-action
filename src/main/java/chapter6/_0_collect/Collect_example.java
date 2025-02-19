package chapter6._0_collect;

import common.trade.Currency;
import common.trade.Transaction;
import common.trade.TransactionExample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Collect_example {

    public static void main(String[] args) {

        //람다 x
        Map<Currency, List<Transaction>> transactionsByCurrency = new HashMap<>();

        for (Transaction transaction : TransactionExample.transactions) {
            Currency currency = transaction.getCurrency();
            List<Transaction> transactionsForCurrency = transactionsByCurrency.get(currency);

            if (transactionsForCurrency == null) {
                transactionsForCurrency = new ArrayList<>();
                transactionsByCurrency.put(currency, transactionsForCurrency);
            }

            transactionsForCurrency.add(transaction);
        }

        //collect
        Map<Currency, List<Transaction>> transactionsByCurrencies =
                TransactionExample.transactions.stream()
                        .collect(Collectors.groupingBy(Transaction::getCurrency));
    }
}
