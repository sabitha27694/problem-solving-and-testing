import java.util.Arrays;

class Solution {
    public String largestNumber(int[] nums) {
        // Convert integer array to string array
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }
        
        // Custom sort using the comparator (b + a).compareTo(a + b) for descending order
        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));
        
        // Edge case: if the highest value is "0", the whole number is 0
        if (strNums[0].equals("0")) {
            return "0";
        }
        
        // Join all strings together
        StringBuilder result = new StringBuilder();
        for (String numStr : strNums) {
            result.append(numStr);
        }
        
        return result.toString();
    }
}