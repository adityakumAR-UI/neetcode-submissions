class Solution {
    public int func(int current,int [] nums,int []dp){
        if(current==0) return 1;
        if(current<0) return 0;
        if(dp[current]!=-1) return dp[current];
        

        int t=0;
        for(int i=0;i<nums.length;i++){
            if(current>=nums[i]){
                t+=func(current-nums[i],nums,dp);

            }
        }

        return dp[current]=t;






        
    }
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int [] dp=new int [target+1];
        Arrays.fill(dp,-1);
        return func(target,nums,dp);
    }
}