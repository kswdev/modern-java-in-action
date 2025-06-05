package chapter18._1_system_maintenance;

import common.trade.Transaction;

import static common.trade.TransactionExample.transactions;

public class Imperative {

    public static void main(String[] args) {

        // '어떻게' 에 집중하는 프로그래밍 방
        Transaction mostExpensive = transactions.get(0);
        if (mostExpensive == null)
            throw new RuntimeException("Empty list of transactions");

        for (Transaction transaction : transactions) {
            if (transaction.getValue() > mostExpensive.getValue()) {
                mostExpensive = transaction;
            }
        }
    }
}
