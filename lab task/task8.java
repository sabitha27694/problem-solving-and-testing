import java.util.*;

public class TrafficNavigation {
    public static void main(String[] args) {
        // Simplified representation of route cost analysis
        Map<String, Integer> routes = Map.of("Route A", 25, "Route B", 15, "Route C", 30);
        String optimal = Collections.min(routes.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println("Optimal Route Recommendation: " + optimal);
    }
}