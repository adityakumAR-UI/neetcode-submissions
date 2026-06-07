class Solution {
    public void sortColors(int[] nums) {
        int zero=0;
        int one=0;
        int two=0;
        for( int n : nums){
            if(n==0) zero++;
            if(n==1) one++;
            if(n==2) two++;
        }
        for(int i=0;i<nums.length;i++){
            if(i>=0 && i<zero) nums[i]=0;
            else if(i>=zero && i<zero+one) nums[i]=1;
            else nums[i]=2;
        }
        return;
        
    }
}