class Solution {
    int [][]dp=new int [1001][1001];
    public boolean func(int i,int j,String s){
        if(i>=j) return true;
        if(dp[i][j]!=-1)  {
            if(dp[i][j]==1) return true;
            else return false;
        }

        if(s.charAt(i)==s.charAt(j)){
            boolean f=func(i+1,j-1,s);
            if(f) dp[i][j]=1;
            else dp[i][j]=0;
            return f;
        }
        dp[i][j]=0;
        return false;



    }
    public String longestPalindrome(String s) {
        int n=s.length();
        for(int i=0;i<1001;i++){
            Arrays.fill(dp[i],-1);
        }
        int maxlen=0;
        int start=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(func(i,j,s)){
                    if(j-i+1>maxlen){
                        maxlen=j-i+1;
                        start=i;
                    }

                }
            }
        }
        return s.substring(start,start+maxlen);
        
    }
}
