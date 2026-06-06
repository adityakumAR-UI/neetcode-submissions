class Solution {
    public int majorityElement(int[] nums) {
        int  value=nums[0];
        int  time=1;
        for(int i=1;i<nums.length;i++){
            if(time==0 && nums[i]!=value){
                value=nums[i];
                time=1;
            }
            else if(nums[i]==value){
                time++;
            }
            else if(nums[i]!=value){
                time--;
            }
        }
        return value;
        
    }
}