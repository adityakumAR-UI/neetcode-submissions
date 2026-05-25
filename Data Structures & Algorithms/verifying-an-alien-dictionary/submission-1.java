class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<order.length();i++){
            map.put(order.charAt(i),i);
        }
        boolean flag=true;
        for(int i=1;i<words.length;i++){
            String s=words[i];
            String sp=words[i-1];
            boolean flag1=false;
            boolean changes=false;
            for(int j=0;j<Math.min(s.length(),sp.length());j++){
                if(map.get(s.charAt(j))>map.get(sp.charAt(j))){
                    flag1=true;
                    changes=true;
                    break;
                }
                else if(map.get(s.charAt(j))<map.get(sp.charAt(j))){
                    flag1=false;
                    changes=true;
                    break;
                }
            }
            if(!changes){
                if(s.length()>sp.length()) flag1=true;
                else flag1=false;
            }
            if(!flag1)  return false;
        }
        return true;
        
    }
}