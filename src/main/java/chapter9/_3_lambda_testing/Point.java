package chapter9._3_lambda_testing;

import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.*;

public record Point(int x, int y) {

    public Point moveRight(int distance) {
        return new Point(x + distance, y);
    }

    public final static Comparator<Point> compareByXAndThenY =
        comparing(Point::x).thenComparing(Point::y);

    public static List<Point> moveAllPointsRightBy(List<Point> points, int distance) {
        return points.stream()
                .map(point -> point.moveRight(distance))
                .toList();
    }
}