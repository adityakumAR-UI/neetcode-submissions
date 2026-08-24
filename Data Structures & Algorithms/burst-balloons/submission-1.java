class Solution {

    int[][] dp;

    public int func(int left, int right, int[] nums) {

        if(left > right)
            return 0;

        if(dp[left][right] != -1)
            return dp[left][right];

        int maxi = 0;

        for(int i = left; i <= right; i++) {

            int temp =
                nums[left - 1] * nums[i] * nums[right + 1]
                + func(left, i - 1, nums)
                + func(i + 1, right, nums);

            maxi = Math.max(maxi, temp);
        }

        return dp[left][right] = maxi;
    }

    public int maxCoins(int[] nums) {

        int n = nums.length;

        int[] arr = new int[n + 2];

        arr[0] = 1;
        arr[n + 1] = 1;

        for(int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }

        dp = new int[n + 2][n + 2];

        for(int[] row : dp)
            Arrays.fill(row, -1);

        return func(1, n, arr);
    }
}