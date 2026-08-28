import java.util.*;

public class RideSharingSimulator {
    static class Driver {
        String name; double distance;
        Driver(String name, double distance) { this.name = name; this.distance = distance; }
    }

    public static void main(String[] args) {
        List<Driver> drivers = Arrays.asList(
            new Driver("Alice", 3.5),
            new Driver("Bob", 1.2),
            new Driver("Charlie", 4.0)
        );
        Driver nearest = Collections.min(drivers, Comparator.comparingDouble(d -> d.distance));
        System.out.println("Assigned Driver: " + nearest.name + " (" + nearest.distance + " km away)");
    }
}