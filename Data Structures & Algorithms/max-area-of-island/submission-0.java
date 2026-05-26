class Solution {
    public void bfs(int k,int j,int [][]grid,int [][]vis,int [] count){
        vis[k][j]=1;
        count[0]++;
        int n=grid.length;
        int m=grid[0].length;
        int [] dirr={-1,0,+1,0};
        int [] dirc={0,+1,0,-1};
        for(int i=0;i<4;i++){
            int tempr=k+dirr[i];
            int tempc=j+dirc[i];
            if(tempr>=0 && tempc>=0 && tempr<n && tempc<m && vis[tempr][tempc]==-1 && grid[tempr][tempc]==1){
                bfs(tempr,tempc,grid,vis,count);
            }

        }
        return;

    }
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int [][] vis=new int [n][m];
        for(int i=0;i<n;i++) Arrays.fill(vis[i],-1);
        int maxi=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==-1 && grid[i][j]==1){
                    int [] count=new int [1];
                    count[0]=0;
                    bfs(i,j,grid,vis,count);
                    maxi=Math.max(maxi,count[0]);

                }
            }
        }
        return maxi;
        
    }
}
