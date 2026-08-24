class Solution {
    public int func(int i,int j,String s,String ss,int [][]dp){
        if(j==ss.length()){
            if(i==s.length()) return 0;
            else return s.length()-i;
        }
        if(i==s.length()){
            return ss.length()-j;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        


        int f=0;
        int g=0;
        int h=0;
        if(s.charAt(i)==ss.charAt(j)){
            f=func(i+1,j+1,s,ss,dp);
            g=1+func(i,j+1,s,ss,dp);
            return dp[i][j]=Math.min(f,g);

            
        }
        else{
            f=1+func(i,j+1,s,ss,dp);
            g=1+func(i+1,j,s,ss,dp);
            h=1+func(i+1,j+1,s,ss,dp);
            return dp[i][j]= Math.min(f,Math.min(g,h));

        }

    }
    public int minDistance(String word1, String word2) {
        int [][]dp=new int [word1.length()+1][word2.length()+1];
        for(int i=0;i<=word1.length();i++){
            Arrays.fill(dp[i],-1);
        }
        return func(0,0,word1,word2,dp);
        
    }
}
