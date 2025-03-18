package chapter9._1_refactoring;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ConditionalDeferredExecution {

    private static final Logger logger = Logger.getLogger(ConditionalDeferredExecution.class.getName());
    public static void main(String[] args) {

        // 조건부 연기 실행
        if (logger.isLoggable(Level.FINER)) {
            logger.finer("Problem");
        }

        // logger 의 상태를 logger 객체의 log 메서드가 확인하게 한다.
        // 하지만 로거가 레벨에 맞지 않아 출력되지 않더라도 someExpensiveMethod() 는 동작한다.
        logger.log(Level.FINER, "Problem: " + someExpensiveMethod());

        // 위 문제를 해결해 메시지 생성을 연기한다.
        logger.log(Level.FINER, () -> "Problem: " + someExpensiveMethod());
    }

    private static String someExpensiveMethod() {
        System.out.println("expensiveMethod is running!!");
        return "ExpensiveMethod!!!";
    }
}
