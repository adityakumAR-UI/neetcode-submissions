class Solution {
    public int removeDuplicates(int[] nums) {
        
        // ArrayList<Integer> arr=new ArrayList<>();
        int prev=-1;
        int index=0;
        for(int i=0;i<nums.length;i++){
            if(prev!=nums[i]){
                nums[index]=nums[i];
                index++;
                prev=nums[i];
            }
        }
        
        return index;
        
    }
}