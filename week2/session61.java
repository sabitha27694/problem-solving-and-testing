class Solution {
    public int[] buildArray(int[] nums) {
        int n = nums.length;
        
        // Step 1: Encode both old and new values into nums[i]
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] + n * (nums[nums[i]] % n);
        }
        
        // Step 2: Extract the new values
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] / n;
        }
        
        return nums;
    }
}