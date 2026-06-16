class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
       int [] res=new int [m];
       for(int i=0;i<m;i++){
        res[i]=nums1[i];
       }
       for(int j=n;j<nums1.length;j++){
         nums1[j]=res[j-n];
       }
       for(int i=0;i<n;i++){
        nums1[i]=nums2[i];
       }
       Arrays.sort(nums1);
       return ;
        
    }
}