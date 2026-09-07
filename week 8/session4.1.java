import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String[] pair1 = new String[t];
        String[] pair2 = new String[t];

        for (int i = 0; i < t; i++) {
            pair1[i] = s.next();
            pair2[i] = s.next();
        }

        Set<String> set = new HashSet<>();
        for (int i = 0; i < t; i++) {
            set.add(pair1[i] + " " + pair2[i]);
            System.out.println(set.size());
        }
    }
}