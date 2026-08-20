class Solution {
    public boolean func(int index,String s,List<String> word,int []dp){
        if(index==s.length()) return true;
        if(index>s.length()) return false;
        if(dp[index]!=-1) {
            if(dp[index]==0) return false;
            return true;
        }
        
        
        for(int i=0;i<word.size();i++){
            int len=word.get(i).length();
            if(index+len<=s.length() && s.substring(index,index+len).equals(word.get(i))){
                boolean f=func(index+len,s,word,dp);
                if(f) dp[index]=1;
                if(f) return true;

            }
        }
        dp[index]=0;
        return  false;
        
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        int [] dp=new int [s.length()];
        Arrays.fill(dp,-1);
        return func(0,s,wordDict,dp);
        
    }
}
