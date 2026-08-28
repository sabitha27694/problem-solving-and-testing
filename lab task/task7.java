import java.util.*;
import java.util.regex.*;

public class HashtagCounter {
    public static void main(String[] args) {
        String tweet = "Learning #Java and building #Java apps with #Spring.";
        Map<String, Integer> counts = new HashMap<>();
        Matcher matcher = Pattern.compile("#\\w+").matcher(tweet);
        
        while (matcher.find()) {
            String tag = matcher.group();
            counts.put(tag, counts.getOrDefault(tag, 0) + 1);
        }
        
        counts.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}