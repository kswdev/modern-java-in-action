package chapter3._2_execute_arround.util.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class File {

    //step1
    public String processFile(BufferedReaderProcess p) throws IOException {
        try(BufferedReader br =
                    new BufferedReader(new FileReader("data.txt"))) {
            return p.process(br);
        }
    }
}
