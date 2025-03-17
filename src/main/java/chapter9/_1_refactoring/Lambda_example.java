package chapter9._1_refactoring;

import chapter9.common.RunnableAnonymousWrapper;
import chapter9.common.RunnableLambdaWrapper;
import chapter9.common.Task;

public class Lambda_example {


    public static void main(String[] args) {

        // anonymous class
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World!");
            }
        };

        // lambda expression
        Runnable r2 = () -> System.out.println( "Hello World!");


        //람다와 익명클래스는 this 와 super 가 가리키는 대상이 다르다
        RunnableAnonymousWrapper anonymousWrapper = new RunnableAnonymousWrapper();
        RunnableLambdaWrapper lambdaWrapper = new RunnableLambdaWrapper();

        anonymousWrapper.getRunnable().run();
        lambdaWrapper.getRunnable().run();


        // 익명 클래스는 감싸고 있는 클래스의 변수를 가릴 수 있다.(섀도 변수)_
        // 하지만 람다 표현식으로는 변수를 가릴 수 없다.
        int a = 10;
        Runnable lambdaRunnable = () -> {
            //컴파일 에러
            //int a = 2;
            System.out.println(a);
        };

        Runnable anonymousRunnable = new Runnable() {
            @Override
            public void run() {
                int a = 2;
                System.out.println(a);
            }
        };

        // 익명 클래스를 람다 표현식으로 바꿨을때 콘텍스트 오버로딩에 따른 모호함이 초래될 수 있다.
        doSomething(new Task() {
            @Override
            public void execute() {
                System.out.println("Task");
            }
        });

        // 인터페이스 시그니쳐가 같아 컴파일 에러
        //doSomething(() -> System.out.println( "Task"));
        // 명시적 형변환을 이용하면 된다.
        doSomething((Task) () -> System.out.println( "Task"));
    }

    private static void doSomething(Runnable runnable) {
        runnable.run();
    }

    private static void doSomething(Task task) {
        task.execute();
    }
}
