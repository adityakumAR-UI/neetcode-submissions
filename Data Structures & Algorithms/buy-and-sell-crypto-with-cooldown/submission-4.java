class Solution {
    public int func(int index, boolean buy, int[] prices, int[][] dp) {

        if(index >= prices.length) return 0;

        if(index == prices.length - 1){
            if(buy) return prices[index];
            return 0;
        }

        int g = (buy) ? 1 : 0;

        if(dp[index][g] != -1) return dp[index][g];

        int maxi = 0;

        if(!buy){

            int nottake = func(index + 1, buy, prices, dp);

            int pick = -prices[index] +
                       func(index + 1, true, prices, dp);

            maxi = Math.max(pick, nottake);

        }
        else{

            int nottake = func(index + 1, buy, prices, dp);

            int pick = 0;

            if(index + 2 <= prices.length){
                pick = prices[index] + func(index + 2, false, prices, dp);
            }

            maxi = Math.max(pick, nottake);
        }

        return dp[index][g] = maxi;
    }

    public int maxProfit(int[] prices) {

        int[][] dp = new int[prices.length + 1][2];

        for(int i = 0; i <= prices.length; i++){
            Arrays.fill(dp[i], -1);
        }

        return func(0, false, prices, dp);
    }
}