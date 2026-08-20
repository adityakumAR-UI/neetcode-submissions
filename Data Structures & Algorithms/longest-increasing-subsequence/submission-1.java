class Solution {
    public int func(int index,int prev,int [] nums,int [][]dp){

        if(index==nums.length-1 ){
            if(prev==0) return 1;
            if(nums[index]>nums[prev-1]) return 1;
            return 0;
        }
        if(prev!=-1){
            if( dp[index][prev]!=-1)  return dp[index][prev];
        }

        int nottake=func(index+1,prev,nums,dp);
        int take=0;
        if(prev==0 || nums[index]>nums[prev-1] ){
            take=1+func(index+1,index+1,nums,dp);
        }
        return  dp[index][prev]=Math.max(take,nottake);


    }
    public int lengthOfLIS(int[] nums) {
        int [][]dp=new int [nums.length+1][nums.length+1];
        for(int i=0;i<=nums.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return func(0,0,nums,dp);
        
    }
}
