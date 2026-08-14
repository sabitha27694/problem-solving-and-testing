import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        
        int n = in.nextInt();
        int m = in.nextInt();
        int maxUnique = 0;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            
            // Add new element to deque and set
            deque.add(num);
            set.add(num);
            
            // When deque reaches size M, process the window
            if (deque.size() == m) {
                if (set.size() > maxUnique) {
                    maxUnique = set.size();
                }
                
                // Early exit optimization: maximum possible unique numbers in window size M is M
                if (maxUnique == m) {
                    System.out.println(maxUnique);
                    return;
                }
                
                // Remove the oldest element from the front of the deque
                int removed = deque.removeFirst();
                
                // If the removed element is no longer in the current deque, remove from set
                if (!deque.contains(removed)) {
                    set.remove(removed);
                }
            }
        }
        
        System.out.println(maxUnique);
    }
}