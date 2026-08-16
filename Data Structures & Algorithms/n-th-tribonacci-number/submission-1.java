class Solution {
    public int func(int index,int []dp){
        if(index==0 || index==1) return index;
        if(index==2) return 1;
        if(dp[index]!=-1) return dp[index];

        return dp[index]=func(index-1,dp)+func(index-2,dp)+func(index-3,dp);
    }
    public int tribonacci(int n) {
        int []dp=new int [n+1];
        Arrays.fill(dp,-1);
        return func(n,dp);

        
    }
}