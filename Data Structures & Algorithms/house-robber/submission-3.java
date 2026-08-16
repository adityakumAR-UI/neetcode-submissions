class Solution {
    public int func(int index,int []nums,int []dp){
        // if(index==end+1) return 0;
        if(index==nums.length-1) return nums[nums.length-1];
        if(dp[index]!=-1 ) return dp[index];

        int notpick=0;
        if(index+1<=nums.length-1) notpick=func(index+1,nums,dp);
        int pick=0;
        if(index+2<=nums.length-1) pick=nums[index]+func(index+2,nums,dp);
        else pick=nums[index];
        return dp[index]=Math.max(pick,notpick);
    }
    public int rob(int[] nums) {
        int [] dp=new int [nums.length+1];
        Arrays.fill(dp,-1);
        return func(0,nums,dp);
        
    }
}
