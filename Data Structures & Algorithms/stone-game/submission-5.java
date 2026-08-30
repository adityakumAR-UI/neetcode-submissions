class Solution {

    public int func(int i, int j, int[] piles,int [][]dp) {

        if (i > j)
            return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        int takeLeft = piles[i] - func(i + 1, j, piles,dp);
        int takeRight = piles[j] - func(i, j - 1, piles,dp);

        return dp[i][j]=Math.max(takeLeft, takeRight);
    }

    public boolean stoneGame(int[] piles) {
        int [][]dp=new int [piles.length][piles.length];
        for(int i=0;i<piles.length;i++){
            Arrays.fill(dp[i],-1);
        }

        return func(0, piles.length - 1, piles,dp) > 0;
    }
}