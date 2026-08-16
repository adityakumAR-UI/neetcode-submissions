class Solution {
    public int func(int index,int []cost,int []dp){
        // if(index==cost.length-1) return cost[cost.length-1];
        if(index>=cost.length) return 0;
        if(dp[index]!=-1) return dp[index];


        int  t=cost[index]+func(index+1,cost,dp);
        int f=Integer.MAX_VALUE;
         f=cost[index]+func(index+2,cost,dp);
        return dp[index]=Math.min(t,f);
    }
    public int minCostClimbingStairs(int[] cost) {
        int [] dp=new int [cost.length];
        Arrays.fill(dp,-1);

        return Math.min(func(0,cost,dp),func(1,cost,dp));
        
    }
}
