package common.trade;

import java.util.Arrays;
import java.util.List;

public abstract class TransactionExample {
    public static List<Transaction> transactions = Arrays.asList(
            new Transaction(new Trader("jason"), Currency.USD, 1998, 100),
            new Transaction(new Trader("raoul"), Currency.USD, 1995, 140),
            new Transaction(new Trader("raoul"), Currency.USD, 1993, 200),
            new Transaction(new Trader("mario"), Currency.EUR, 1993, 300),
            new Transaction(new Trader("mario"), Currency.EUR, 1995, 390),
            new Transaction(new Trader("arlan"), Currency.GBP, 1997, 980)
    );
}
