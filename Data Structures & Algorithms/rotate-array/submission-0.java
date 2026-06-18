class Solution {
    public void rotate(int[] nums, int k) {
        ArrayList<Integer> arr=new ArrayList<>();
        k=k%nums.length;
        int n=nums.length;
        for(int i=n-k;i<n;i++){
            arr.add(nums[i]);
        }
        for(int i=n-k-1;i>=0;i--){
             nums[i+k]=nums[i];
        }
        for(int i=0;i<arr.size();i++){
            nums[i]=arr.get(i);
         }
         return ;
    }
}