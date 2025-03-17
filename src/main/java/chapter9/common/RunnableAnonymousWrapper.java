package chapter9.common;

public class RunnableAnonymousWrapper {

    private final Runnable runnable = new Runnable() {
        @Override
        public void run() {
            System.out.println(this);
        }

        @Override
        public String toString() {
            return "RunnableAnonymous{" + "anonymous" + "}";
        }
    };

    public Runnable getRunnable() {
        return runnable;
    }

    @Override
    public String toString() {
        return "RunnableAnonymousWrapper{" + "anonymousWrapper" + "}";
    }
}
