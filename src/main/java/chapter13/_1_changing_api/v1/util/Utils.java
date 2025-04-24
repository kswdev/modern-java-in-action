package chapter13._1_changing_api.v1.util;

import chapter13._1_changing_api.v1.resizable.Resizable;

import java.util.List;

public class Utils {

    public static void paint(List<Resizable> l) {
        l.forEach(r -> {
            r.setAbsoluteSize(42, 43);
            r.draw();
        });
    }
}
