class Solution {
    public int removeDuplicates(int[] nums) {
        
        ArrayList<Integer> arr=new ArrayList<>();
        int prev=-1;
        for(int i=0;i<nums.length;i++){
            if(prev!=nums[i]){
                arr.add(nums[i]);
                prev=nums[i];
            }
        }
        int n=arr.size();
        for(int i=0;i<n;i++){
            nums[i]=arr.get(i);
        }
        return arr.size();
        
    }
}