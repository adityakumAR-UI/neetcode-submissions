class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;
        Arrays.sort(nums);
        int count=1;
        int maxi=-1;
        for(int i=1;i<n;i++){
            if(nums[i-1]+1==nums[i]){
                count++;
            }
            else if(nums[i-1]==nums[i]) continue;
            else {
                maxi=Math.max(count,maxi);
                count=1;
            }
        }
         maxi=Math.max(count,maxi);
        return  maxi;
        
    }
}
