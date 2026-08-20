class Solution {

    public int func(int curr, int[] dp) {

        if (curr == 1) return 1;

        if (dp[curr] != -1) return dp[curr];

        int h = Integer.MIN_VALUE;

        for (int i = 2; i <= 58; i++) {

            if (curr >= i) {

                // Take i as one part
                int g = i * Math.max(1, func(curr - i, dp));

                h = Math.max(h, g);
            }
            else break;
        }

        return dp[curr] = h;
    }

    public int integerBreak(int n) {

        if (n == 2) return 1;
        if (n == 3) return 2;

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return func(n, dp);
    }
}