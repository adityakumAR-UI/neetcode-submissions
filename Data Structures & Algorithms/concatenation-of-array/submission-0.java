class Solution {
    public int[] getConcatenation(int[] nums) {
        int [] res=new int [nums.length*2];
        for(int i=0;i<nums.length;i++){
            res[i]=nums[i];
        }
        for(int j=nums.length;j<res.length;j++){
            res[j]=nums[j-nums.length];
        }
        return res;
        
    }
}