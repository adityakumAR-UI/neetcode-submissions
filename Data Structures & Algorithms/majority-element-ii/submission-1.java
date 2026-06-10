class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> arr=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for( int n : nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        int t=nums.length/3;
        // if(nums.length%3==0) t++;
        for(Integer n : map.keySet()){
            if(map.get(n)>t) arr.add(n);
        }
        return arr;
        
    }
}