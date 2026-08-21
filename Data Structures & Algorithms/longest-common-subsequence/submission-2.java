class Solution {
    public int func(int i,int j,String s,String ss,int [][]dp){
        if(i==s.length() || j==ss.length()) return 0;
        
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==ss.charAt(j)){
            return dp[i][j]= 1+func(i+1,j+1,s,ss,dp);
        }
        int down=0;
        if(j+1<ss.length()){
            down=func(i,j+1,s,ss,dp);

        }
        int up=0;
        if(i+1<s.length()){
            up=func(i+1,j,s,ss,dp);

        }
        return dp[i][j]=Math.max(down,up);
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int [][] dp=new int [text1.length()+1][text2.length()];
        for(int i=0;i<=text1.length();i++){
            Arrays.fill(dp[i],-1);

        }
        return func(0,0,text1,text2,dp);
        
    }
}
