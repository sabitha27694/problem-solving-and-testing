import java.util.LinkedList;
import java.util.Queue;

public class StreamAnalyticsEngine {
    private final int windowSize;
    private final Queue<Double> window = new LinkedList<>();
    private double sum = 0;

    public StreamAnalyticsEngine(int windowSize) {
        this.windowSize = windowSize;
    }

    public double addDataPoint(double value) {
        window.add(value);
        sum += value;
        if (window.size() > windowSize) {
            sum -= window.poll();
        }
        return sum / window.size();
    }

    public static void main(String[] args) {
        StreamAnalyticsEngine engine = new StreamAnalyticsEngine(3);
        System.out.println("Moving Avg: " + engine.addDataPoint(10.0));
        System.out.println("Moving Avg: " + engine.addDataPoint(20.0));
        System.out.println("Moving Avg: " + engine.addDataPoint(30.0));
        System.out.println("Moving Avg: " + engine.addDataPoint(40.0));
    }
}