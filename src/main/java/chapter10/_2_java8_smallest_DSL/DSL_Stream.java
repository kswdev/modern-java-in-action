package chapter10._2_java8_smallest_DSL;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DSL_Stream {

    public static void main(String[] args) throws IOException {
        String filename = "data.txt";
        int count = 40;
        List<String> errors;

        errors = collectLinesWithErrorUsingClassicCode(filename, count);
        errors = collectLinesWithErrorUsingStream(filename, count);


    }

    // Stream 인터페이스를 이용해 함수형으로 코드를 구현
    private static List<String> collectLinesWithErrorUsingStream(String filename, int count) throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(filename))) {
            return lines
                    .filter(line -> line.contains("ERROR"))
                    .limit(count)
                    .toList();
        }
    }

    /*
     * 코드가 이미 장황해 의도를 한 눈에 파악하기 어렵다. 문제가 분리되지 않아 가독성과 유지보수성 모두 저하되었다. 같은 의무를 지닌 코드가 여러 행에 분산되어 있다.(파일을 읽는 로직)

     * - FileReader 가 만들어짐
     * - 파일이 종료되었는지 확인하는 while 루프의 두 번째 조건
     * - 파일의 다음 행을 읽는 while 루프의 마지막행

     * 마찬가지로 첫 40행을 수집하는 코드도 세 부분으로 흩어져있다.

     * - errorCount 변수를 초기화하는 코드
     * - while 루프의 첫 번째 조건
     * - "Error"을 로그에서 발견하면 카운터를 증가시키는 행
     */
    private static List<String> collectLinesWithErrorUsingClassicCode(String filename, int count) throws IOException {
        List<String> errors = new ArrayList<>();
        int errorCount = 0;
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line = br.readLine();
        while (errorCount < count && line != null) {
            if (line.contains("ERROR")) {
                errors.add(line);
                errorCount++;
            }
            line = br.readLine();
        }
        br.close();
        return errors;
    }
}
