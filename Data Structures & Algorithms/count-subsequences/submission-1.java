class Solution {
    public int func(int i,int j,String s,String ss,int [][]dp){
        if(j==ss.length()) return 1;
        if(i==s.length()) return 0;
        if(dp[i][j]!=-1) return dp[i][j];

        int f=0;
        if(s.charAt(i)==ss.charAt(j)){
             f=func(i+1,j+1,s,ss,dp);
            
            
        }
        int g=func(i+1,j,s,ss,dp);
        return dp[i][j]=f+g;


    }
    public int numDistinct(String s, String t) {
        int [][]dp=new int [s.length()+1][t.length()+1];
        for(int i=0;i<s.length()+1;i++){
            Arrays.fill(dp[i],-1);
        }
        return func(0,0,s,t,dp);
        
    }
}
