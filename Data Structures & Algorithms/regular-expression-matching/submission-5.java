class Solution {

    public boolean func(int i, int j, String s, String p,int [][]dp) {

        // Pattern is finished
        if (j == p.length()) {
            return i == s.length();
        }
         if(dp[i][j]!=-1) return dp[i][j]==1;
        // Check whether current characters match
        boolean match = false;

        if (i < s.length()) {
            if (p.charAt(j) == '.' ||
                p.charAt(j) == s.charAt(i)) {

                match = true;
            }
        }

        // Current character is followed by '*'
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {

            // Case 1: take zero occurrences
            boolean zero = func(i, j + 2, s, p,dp);

            // Case 2: take one occurrence
            boolean oneOrMore = false;

            if (match) {
                oneOrMore = func(i + 1, j, s, p,dp);
            }
            boolean h=zero || oneOrMore;
            if(h) dp[i][j]=1;
            else dp[i][j]=0;
            return h;
        }

        // Normal character or '.'
        if (match) {
            boolean hp=func(i + 1, j + 1, s, p,dp);
            if(hp) dp[i][j]=1;
            else dp[i][j]=0;
            return hp;
        }

         dp[i][j]=0; return false;
    }

    public boolean isMatch(String s, String p) {
        int[][] dp=new int [s.length()+1][p.length()+1];
    for(int i=0;i<=s.length();i++) Arrays.fill(dp[i],-1);
        return func(0, 0, s, p,dp);
    }
}