class Solution {
    public int func(int index,int target,int [] amount,int [][]dp){
        if(index==amount.length){
            if(target==0) return 1;
            return 0;

        }
        if(dp[index][target]!=-1) return dp[index][target];


        int nottake=func(index+1,target,amount,dp);
        int take=0;
        if(target>=amount[index]){
            take=func(index,target-amount[index],amount,dp);
        }
        return dp[index][target]=nottake+take;
    }
    public int change(int amount, int[] coins) {
        int [][]dp=new int[coins.length+1][amount+1];
        for(int i=0;i<=coins.length;i++){
            Arrays.fill(dp[i],-1);

        }
        return func(0,amount,coins,dp);
        
    }
}
