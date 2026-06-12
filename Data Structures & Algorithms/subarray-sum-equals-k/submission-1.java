class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int cont=0;
        int sum=0;
        for( int np : nums){
            sum+=np;
            if(map.containsKey(sum-k)){
                cont+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return cont;
        
    }
}