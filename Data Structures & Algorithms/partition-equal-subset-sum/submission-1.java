class Solution {
    public boolean func(int index,int amount,int [] nums,int [][]dp){
        if(amount==0) return true;
        if(amount<0) return false;
        if(index==nums.length){
            if(amount==0) return true;
            return false;
        }
        if(dp[index][amount]!=-1) {
            if(dp[index][amount]==0) return false;
            return true;
        }

        boolean nottake=func(index+1,amount,nums,dp);
        boolean take=false;
        if(amount>=nums[index]){
            take=func(index+1,amount-nums[index],nums,dp);
        }
        boolean res=nottake || take;
        if(res) dp[index][amount]=1;
        else dp[index][amount]=0;
        return res;
    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        for (int n : nums) sum+=n;
        int [][] dp=new int [nums.length][(sum/2)+1];
        for(int i=0;i<nums.length;i++){
            Arrays.fill(dp[i],-1);
        }
        if(sum%2!=0) return false;
        return func(0,sum/2,nums,dp);
        
    }
}
