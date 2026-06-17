class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int index1=-1;
        int index2=-1;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<numbers.length;i++){
            if(map.containsKey(target-numbers[i])){
                index1=map.get(target-numbers[i]);
                index2=i;
                break;
            }
            map.put(numbers[i],i);
        }
        return new int []{index1+1,index2+1};
        
    }
}
