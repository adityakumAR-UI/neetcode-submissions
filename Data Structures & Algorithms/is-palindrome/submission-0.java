class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sp=new StringBuilder();
        String a=s.toLowerCase();
        for(int i=0;i<s.length();i++){
            if((a.charAt(i)>='a' && a.charAt(i)<='z') || (a.charAt(i)>='0' && a.charAt(i)<='9')){
                sp.append(a.charAt(i));
            }
        }
        a=sp.toString();
        int i=0;
        int j=a.length()-1;
        while(i<=j){
            if(a.charAt(i)!=a.charAt(j)) {
                return false;
            }
            i++;j--;
        }
        
        return true;
    }
}
