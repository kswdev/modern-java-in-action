package chapter9._3_lambda_testing;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    void testMoveRightBy() {
        Point p1 = new Point(5, 5);
        Point p2 = p1.moveRight(10);
        assertEquals(15, p2.x());
        assertEquals(5, p2.y());
    }

    @Test
    void testComparingTwoPoints() {
        Point p1 = new Point(10, 15);
        Point p2 = new Point(10, 20);

        int result = Point.compareByXAndThenY.compare(p1, p2);
        assertTrue(result < 0);
    }

    @Test
    void testMoveAllPointsRightBy() {
        List<Point> points =
                List.of(new Point(5, 5), new Point(10, 5));

        List<Point> expectedPoints =
                List.of(new Point(15, 5), new Point(20, 5));

        List<Point> actualPoints = Point.moveAllPointsRightBy(points, 10);

        assertEquals(expectedPoints, actualPoints);
    }
}