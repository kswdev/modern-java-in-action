package chapter10._3_java_dsl_pattern.model;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private String customer;
    private double value;
    private List<Trade> trades = new ArrayList<>();

    public String getCustomer() { return customer; }
    public double getValue() { return value; }
    public void addTrade(Trade trade) { trades.add(trade); }

    public void setCustomer(String customer) { this.customer = customer; }
    public List<Trade> getTrades() { return trades; }
}