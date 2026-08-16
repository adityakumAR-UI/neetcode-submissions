class Solution {
    public int func(int index,int end,int []nums,int []dp){
        // if(index==end+1) return 0;
        if(index==end) return nums[end];
        if(dp[index]!=-1 ) return dp[index];

        int notpick=0;
         if(index+1<=end) notpick=func(index+1,end,nums,dp);
        int pick=0;
        if(index+2<=end) pick=nums[index]+func(index+2,end,nums,dp);
        else pick=nums[index];
        return dp[index]=Math.max(pick,notpick);
    }
    public int rob(int[] nums) {
        if(nums.length<2){
            if( nums.length==0) return 0;
            if(nums.length==1 ) return nums[0];
             if(nums.length==2) return Math.max(nums[0],nums[1]);

        }
        int [] dp=new int [nums.length+1];
        Arrays.fill(dp,-1);
        int [] dp1=new int [nums.length+1];
        Arrays.fill(dp1,-1);
        return Math.max(func(0,nums.length-2,nums,dp),func(1,nums.length-1,nums,dp1));
        
    }
}
