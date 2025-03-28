package chapter7._3_spliterator.counter;

public abstract class LoopCounter {

    public static int countWordsIteratively(String s) {
        int count = 0;
        boolean lastSpace = true;
        for (char c : s.toCharArray()) {
            if (Character.isWhitespace(c)) {
                lastSpace = true;
            } else if (lastSpace) {
                count++;
                lastSpace = false;
            }
        }
        return count;
    }
}
