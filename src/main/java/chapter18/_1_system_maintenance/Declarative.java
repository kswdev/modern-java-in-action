package chapter18._1_system_maintenance;

import common.trade.Transaction;

import java.util.Optional;

import static common.trade.TransactionExample.transactions;
import static java.util.Comparator.comparingInt;

public class Declarative {

    public static void main(String[] args) {
        Optional<Transaction> mostExpensive =
                transactions.stream()
                            .max(comparingInt(Transaction::getValue));
    }
}
