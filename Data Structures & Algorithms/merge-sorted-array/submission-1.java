class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1;
        int j=n-1;
        int k =m+n-1;
        while(i>=0 || j>=0){
            int a= i>=0 ? nums1[i] : Integer.MIN_VALUE;
            int b= j>=0 ? nums2[j] : Integer.MIN_VALUE;
            if(a>b){
                nums1[k]=a;
                i--;
                k--;
            }
            else{
                nums1[k]=b;
                k--;
                j--;
            }

        }
        return ;
        
    }
}