class Solution {
    public boolean func(int index,int []arr,int target,int [][]dp){
        if(index==arr.length){
            if(target==0) return true;
            else return false;
        }
        if(dp[index][target]!=-1) {
            if(dp[index][target]==1) return true;
            return false;
        }

        boolean notpick=func(index+1,arr,target,dp);
        boolean pick=false;
        if(target>=arr[index]){
            pick=func(index+1,arr,target-arr[index],dp);
        }
        boolean h=pick || notpick;
        if(h) dp[index][target]=1;
        else dp[index][target]=0;
        return h;

    }
    public int lastStoneWeightII(int[] stones) {
        int target=0;
        for(int n : stones) target+=n;
        int [][]dp=new int [stones.length+1][(target/2)+1];
        for(int i=0;i<=stones.length;i++){
            Arrays.fill(dp[i],-1);
        }
        for(int h=target/2;h>=0;h--){
            if(func(0,stones,h,dp)){
                return target-2*h;
            }
        }
        return 0;
        
    }
}