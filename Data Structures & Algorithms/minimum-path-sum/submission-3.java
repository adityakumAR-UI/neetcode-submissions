class Solution {
    public int func(int i,int j,int [][]grid,int [][]dp){
        int n=grid.length;
        int m=grid[0].length;
        if(i==n && j==m) return 0;
        
        
        if(dp[i][j]!=-1) return dp[i][j];
        int down=Integer.MAX_VALUE;
        if(j+1<m){
            down=grid[i][j]+func(i,j+1,grid,dp);
        }
        int right=Integer.MAX_VALUE;
        if(i+1<n){
            right=grid[i][j]+func(i+1,j,grid,dp);
        }
        int res=Math.min(down,right);
        if(res==Integer.MAX_VALUE) return dp[i][j]= grid[i][j];
        else return dp[i][j]=res;
        
    }
    public int minPathSum(int[][] grid) {
        int [][]dp=new int [grid.length+2][grid[0].length+2];
        for(int i=0;i<=grid.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return func(0,0,grid,dp);
        
    }
}