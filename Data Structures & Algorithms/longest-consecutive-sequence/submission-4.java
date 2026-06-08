class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        if (nums.length == 0)
            return 0;
        for (int n : nums) {
            set.add(n);
        }

        int maxi = -1;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (!set.contains(n-1)) {
                
                int count = 0;
                while (set.contains(n)) {
                    count++;
                    n = n + 1;
                }
                maxi = Math.max(maxi, count);
            }
        }
        return maxi;
    }
}
