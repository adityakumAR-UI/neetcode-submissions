class Solution {
    int count=0;
    public boolean func(int i,int j,String s){
        if(i>j){
            return true;
        }
        if(s.charAt(i)==s.charAt(j)){
            return func(i+1,j-1,s);
        }
        else {
            count++;
            if(count>1) return false;
            return func(i,j-1,s) || func(i+1,j,s);
        }
    }
    public boolean validPalindrome(String s) {
        return func(0,s.length()-1,s);

        
    }
}