class Solution {
    public void bfs(int k,int j,char [][] grid,int [][]vis){
        vis[k][j]=1;
        int n=grid.length;
        int m=grid[0].length;
        int [] dirr={-1,0,+1,0};
        int [] dirc={0,+1,0,-1};
        for(int i=0;i<4;i++){
            int tempr=k+dirr[i];
            int tempc=j+dirc[i];
            if(tempr>=0 && tempc>=0 && tempr<n && tempc<m && grid[tempr][tempc]=='1'){
                if(vis[tempr][tempc]==-1) {
                    bfs(tempr,tempc,grid,vis);
                }

            }
        }
        return;

    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int [][] vis=new int [n][m];
        for(int i=0;i<n;i++) Arrays.fill(vis[i],-1);
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==-1 && grid[i][j]=='1'){
                    bfs(i,j,grid,vis);
                    count++;
                }
            }
        }
        return count;
        
    }
}
