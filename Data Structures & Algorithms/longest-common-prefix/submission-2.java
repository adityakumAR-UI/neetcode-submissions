class Solution {
    public String longestCommonPrefix(String[] strs) {
        String s="";
        int minf=1000000;
        for(String sp : strs) minf=Math.min(minf,sp.length());
        String t=strs[0];
        for(int i=0;i<minf;i++){
            boolean flag=true;
            for(int j=1;j<strs.length;j++){
                // if(strs[j].length() < t.length()){
                //     if(i==strs[j].length()-1) break;
                // }
                if(strs[j].charAt(i)!=t.charAt(i)){
                    flag=false;
                    break;
                }
            } 
            if(flag) s+=t.charAt(i);
            else return s;           
        }
        return s;
        
    }
}