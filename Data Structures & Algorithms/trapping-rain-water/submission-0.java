class Solution {
    public int trap(int[] height) {
        if(height.length==0 || height==null) return 0;
        int n=height.length;
        int res=0;
        for(int i=0;i<n;i++){
            int leftmax = height[i];
            int rightmax = height[i];
            for(int j=0;j<i;j++){
                leftmax=Math.max(leftmax,height[j]);
            }
            for(int k=i+1;k<n;k++){
                rightmax=Math.max(rightmax,height[k]);

            }
            res+=Math.min(rightmax,leftmax)-height[i];

        }
        return res;
    }
}
