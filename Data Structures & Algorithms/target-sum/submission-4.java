class Solution {
    public int func(int index, int[] nums, int target, int[][] dp, int t) {

        if(index == nums.length){
            if(target == 0) return 1;
            return 0;
        }

        // target is outside DP range
        if(target < -t || target > t) return 0;

        if(dp[index][target + t] != -1)
            return dp[index][target + t];

        int subtract = func(index + 1, nums, target - nums[index], dp, t);

        int add = func(index + 1, nums, target + nums[index], dp, t);

        return dp[index][target + t] = add + subtract;
    }

    public int findTargetSumWays(int[] nums, int target) {

        int t = 0;

        for(int n : nums)
            t += n;

        if(target < -t || target > t)
            return 0;

        int[][] dp = new int[nums.length + 1][2 * t + 1];

        for(int i = 0; i <= nums.length; i++){
            Arrays.fill(dp[i], -1);
        }

        return func(0, nums, target, dp, t);
    }
}