class Solution {
    public int func(int k, int m, int[] piles,int [][]dp) {

        if (k >= piles.length)
            return 0;
        if(dp[k][m]!=-1) return dp[k][m];
        int sum = 0;
        int res = Integer.MIN_VALUE;

        for (int x = 1; x <= 2 * m && k + x <= piles.length; x++) {

            sum += piles[k + x - 1];

            int newM = Math.max(m, x);

            int tempres = sum - func(k + x, newM, piles,dp);

            res = Math.max(res, tempres);
        }

        return dp[k][m]=res;
    }

    public int stoneGameII(int[] piles) {

        int sum = 0;

        for (int n : piles) {
            sum += n;
        }
        int [][] dp=new int [piles.length][piles.length+1];
        for(int i=0;i<piles.length;i++){
            Arrays.fill(dp[i],-1);
        }

        int temp = func(0, 1, piles,dp);

        return (sum + temp) / 2;
    }
}