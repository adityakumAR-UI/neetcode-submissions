class Solution {
    public int maxArea(int[] heights) {
        int n=heights.length;
        int area=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                area=Math.max(area,Math.min(heights[j],heights[i])*(j-i));
            }
        }
        return area;
        
    }
}
