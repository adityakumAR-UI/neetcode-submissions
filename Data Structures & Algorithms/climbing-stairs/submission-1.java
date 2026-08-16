class Solution {
    public int func(int index,int n ,int []dp){
        if(index==n) return 1;
         if(dp[index]!=-1 ) return dp[index];
        int t=func(index+1,n,dp);
        int f=0;
        if(index+2<=n)  f=func(index+2,n,dp);
        return dp[index]=t+f;
    }
    public int climbStairs(int n) {
        int []dp=new int [n+1];
        Arrays.fill(dp,-1);
        return func(0,n,dp);
        
    }
}
