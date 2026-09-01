import java.util.Scanner;

public class SmartTrafficNavigation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter traffic level (Low/Medium/High): ");
        String traffic = sc.nextLine();

        System.out.print("Enter distance in km: ");
        double distance = sc.nextDouble();

        double speed;

        if (traffic.equalsIgnoreCase("Low")) {
            speed = 50;
        } 
        else if (traffic.equalsIgnoreCase("Medium")) {
            speed = 35;
        } 
        else {
            speed = 20;
        }

        double time = distance / speed;

        System.out.println("\n--- Smart Traffic Navigation ---");
        System.out.println("Traffic Level : " + traffic);
        System.out.println("Distance      : " + distance + " km");
        System.out.println("Recommended Speed : " + speed + " km/h");
        System.out.println("Estimated Time : " + time + " hours");

        if (traffic.equalsIgnoreCase("High")) {
            System.out.println("Suggestion: Avoid this route and take an alternate route.");
        } 
        else {
            System.out.println("Suggestion: Continue on this route.");
        }

        sc.close();
    }
}

