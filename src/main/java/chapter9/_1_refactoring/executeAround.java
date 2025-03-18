package chapter9._1_refactoring;

import chapter3._2_execute_arround.util.file.BufferedReaderProcess;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class executeAround {

    public static void main(String[] args) throws IOException {
        String oneLine = processFile(BufferedReader::readLine);
        String twoLine = processFile(b -> b.readLine() + "\n" + b.readLine());
    }

    public static String processFile(BufferedReaderProcess p) throws IOException {
        try(BufferedReader br =
                    new BufferedReader(new FileReader("data.txt"))) {
            return p.process(br);
        }
    }
}
