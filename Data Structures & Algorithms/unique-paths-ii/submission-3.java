class Solution {
    public int func(int i,int j,int [][]grid,int [][]dp){
        int n=grid.length;
        int m=grid[0].length;
        if(i>n || j>m) return 0;
        if(i==n-1 && j==m-1 ) {
            if(grid[i][j]!=1) return 1;
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];

        if(grid[i][j]==1) return 0;
        int down=0;
        if(j+1<m){
            down=func(i,j+1,grid,dp);
        }
        int right=0;
        if(i+1<n){
            right=func(i+1,j,grid,dp);
        }
        return dp[i][j]=right+down;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
         int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;
        int [][]dp=new int [n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return func(0,0,obstacleGrid,dp);
    }
}