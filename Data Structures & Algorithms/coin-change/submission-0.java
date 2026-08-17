class Solution {
    public int func(int index,int [] coins,int amount){
        if(index==coins.length) return Integer.MAX_VALUE;
        if(index==coins.length-1){
            if(amount % coins[index]==0){
                return amount/coins[index];
            }
            return Integer.MAX_VALUE;
        }

        int nottake=func(index+1,coins,amount);
        int take=Integer.MAX_VALUE;
        if(coins[index]<=amount) {
            int temp = func(index, coins, amount - coins[index]);

            if (temp != Integer.MAX_VALUE) {
                take = 1 + temp;
            }
        }
        return Math.min(nottake,take);

    }
    public int coinChange(int[] coins, int amount) {
        int ans= func(0,coins,amount);
        if(ans>=Integer.MAX_VALUE) return -1;
        else return ans;
        
    }
}
