package chapter3._2_execute_arround;

import chapter3._2_execute_arround.util.file.File;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File();

        System.out.println(file.processFile((br -> br.readLine() + "\n" + br.readLine())));
    }
}
