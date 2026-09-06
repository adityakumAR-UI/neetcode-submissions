class Solution {
    public int func(int i,int j,int [][] grid,int [][]dp){
        if(i>=grid.length || j>=grid[0].length) return 0;

        if(dp[i][j]!=-1) return dp[i][j];
         int res=1;
        int [] dirr={-1,0,+1,0};
        int [] dirc={0,+1,0,-1};
        for(int k=0;k<4;k++){
            int tempr=dirr[k]+i;
            int tempc=dirc[k]+j;
            if(tempr>=0 && tempc>=0 && tempr<grid.length && tempc<grid[0].length && grid[tempr][tempc]>grid[i][j]){
                res=Math.max(res,1+func(tempr,tempc,grid,dp));

            }
        }
        return dp[i][j]=res;

    }
    public int longestIncreasingPath(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;

        if(n==1 && m==1 ) return 1;

        int [][] dp=new int [n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        int maxi=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                maxi=Math.max(maxi,func(i,j,matrix,dp));

            }
        }
        return maxi;
        
    }
}
