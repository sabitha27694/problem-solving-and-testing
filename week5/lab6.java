import java.util.*;

public class Main {

    static class Driver {
        String name;
        boolean available = true;

        Driver(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Driver[] drivers = {
            new Driver("John"),
            new Driver("Mike"),
            new Driver("David")
        };

        System.out.print("Enter rider name: ");
        String rider = sc.nextLine();

        for (Driver d : drivers) {
            if (d.available) {
                System.out.println(rider + " is assigned to " + d.name);
                d.available = false;
                break;
            }
        }

        sc.close();
    }
}