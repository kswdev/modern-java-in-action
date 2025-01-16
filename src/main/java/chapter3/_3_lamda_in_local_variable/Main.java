package chapter3._3_lamda_in_local_variable;

public class Main {

    public static void main(String[] args) {

        // final 로 사용되거나 사실상 그렇게 사용되는 변수는 람다 바디 안에 사용 가능
        int portNumber = 1337;
        Runnable r = () -> System.out.println(portNumber);

        // 만약 변수 값이 변경된다면 에러 발생
        //portNumber = 1;
    }
}
