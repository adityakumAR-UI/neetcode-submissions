class Solution {
    public int func(int index, int[] dp) {
        if (index == 0)
            return 0;
        if (index < 0)
            return -1;
        if (dp[index] != -2)
            return dp[index];

        int val = Integer.MAX_VALUE;
        for (int i = 1; i <= 100; i++) {
            if (i * i <= index) {
                int g = func(index - i * i, dp);
                if (g != -1) {
                    int c = 1 + g;
                    val = Math.min(val, c);
                }
            }
            else break;
        }
        return dp[index] = (val == Integer.MAX_VALUE) ? -1 : val;
    }
    public int numSquares(int n) {
        int[] dp = new int[n + 2];
        
        dp[0] = -1;
        dp[1] = 0;

        for (int index = 2; index <= n+1; index++) {
            int val = Integer.MAX_VALUE;
            for (int i = 1; i <= 100; i++) {
                if (i * i <= index -1) {
                    int g = dp[(index - i * i)];
                    if (g != -1) {
                        int c = 1 + g;
                        val = Math.min(val, c);
                    }
                }
                else break;
            }
            if(val==Integer.MAX_VALUE ) dp[index]=-1;
            else dp[index]=val;
        }

        return dp[n+1];
    }
}