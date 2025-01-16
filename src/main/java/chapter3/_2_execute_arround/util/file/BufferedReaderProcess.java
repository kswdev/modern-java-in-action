package chapter3._2_execute_arround.util.file;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface BufferedReaderProcess {

    String process(BufferedReader br) throws IOException;
}