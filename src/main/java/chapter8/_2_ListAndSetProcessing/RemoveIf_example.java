package chapter8._2_ListAndSetProcessing;

import java.util.ArrayList;
import java.util.List;

public class RemoveIf_example {

    public static void main(String[] args) {

        List<Transaction> transactions = new ArrayList<>();

        transactions.add(new Transaction("2"));
        transactions.add(new Transaction("3"));
        transactions.add(new Transaction("3"));
        transactions.add(new Transaction("4"));
        transactions.add(new Transaction("5"));
        transactions.add(new Transaction("2"));
        transactions.add(new Transaction("4"));

        // ConcurrentModificationException 에러 발생
        for (Transaction transaction : transactions) {
            if (Character.isDigit(transaction.getReferenceCode().charAt(0))) {
                //transactions.remove(transaction);
                transaction.setReferenceCode("sdf");
            }
        }

        /*// 위 코드 해석
        for (Iterator<Transaction> iterator = transactions.iterator();
             iterator.hasNext();) {
            Transaction transaction = iterator.next();
            if (Character.isDigit(transaction.referenceCode().charAt(0))) {
                *//* iterator 가 순회중에 컬렉션의 크기 변경을 감지하고 에러를 던짐 *//*
                transactions.remove(transaction);
            }
        }

        // 해결
        for (Iterator<Transaction> iterator = transactions.iterator();
            iterator.hasNext();) {
            Transaction transaction = iterator.next();
            if (Character.isDigit(transaction.referenceCode().charAt(0))) {
                iterator.remove();
            }
        }

        //removeIf
        transactions.removeIf(transaction ->
                Character.isDigit(transaction.referenceCode().charAt(0)));*/
    }

    private static class Transaction {
        String referenceCode;

        public Transaction(String referenceCode) {
            this.referenceCode = referenceCode;
        }

        public String getReferenceCode() {
            return referenceCode;
        }

        public void setReferenceCode(String referenceCode) {
            this.referenceCode = referenceCode;
        }
    }
}
