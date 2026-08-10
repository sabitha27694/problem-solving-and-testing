import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        List<List<Integer>> lines = new ArrayList<>();
        
        // Read lines of integers
        for (int i = 0; i < n; i++) {
            int d = scanner.nextInt();
            List<Integer> line = new ArrayList<>();
            for (int j = 0; j < d; j++) {
                line.add(scanner.nextInt());
            }
            lines.add(line);
        }
        
        // Process queries
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            
            // Convert 1-based queries to 0-based indices and validate bounds
            if (x >= 1 && x <= lines.size()) {
                List<Integer> currentLine = lines.get(x - 1);
                if (y >= 1 && y <= currentLine.size()) {
                    System.out.println(currentLine.get(y - 1));
                } else {
                    System.out.println("ERROR!");
                }
            } else {
                System.out.println("ERROR!");
            }
        }
        
        scanner.close();
    }
}