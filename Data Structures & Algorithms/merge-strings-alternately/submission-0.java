class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder s=new StringBuilder();
        
        for(int i=0;i<Math.min(word1.length(),word2.length());i++){
            s.append(word1.charAt(i));
             s.append(word2.charAt(i));
        }
        int left=Math.min(word1.length(),word2.length());
        int right=Math.min(word1.length(),word2.length());
        while(left<word1.length()){
            s.append(word1.charAt(left));
            left++;

        }
        while(right<word2.length()){
            s.append(word2.charAt(right));
            right++;

        }
        return s.toString();
        
    }
}