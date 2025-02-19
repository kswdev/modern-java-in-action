package common.trade;

public class Transaction {
    private final Currency currency;
    private final Trader trader;
    private final int year;
    private final int value;

    public Transaction(Trader trader, Currency currency, int year, int value) {
        this.trader = trader;
        this.currency = currency;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return trader;
    }

    public Currency getCurrency() {
        return currency;
    }

    public int getYear() {
        return year;
    }

    public int getValue() {
        return value;
    }
}
