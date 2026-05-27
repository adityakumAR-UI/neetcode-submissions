class Solution {
    class pair{
        int row;
        int col;
        pair(int f,int s){
            this.row=f;
            this.col=s;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int [][] vis=new int [n][m];
        for(int i=0;i<n;i++) Arrays.fill(vis[i],-1);
        int t=0;
        int res=0;
        Queue<pair> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1) t++;
                if(grid[i][j]==2){
                     q.offer(new pair(i,j));
                     vis[i][j]=1;
                     t++;

                }
            }
        }
        if(t==0) return 0;
        int recheck=0;
        while(q.size()>0){
            int np=q.size();
            
            res++;
            for(int j=0;j<np;j++){
                recheck++;
                pair p=q.poll();
                int r=p.row;
                int c=p.col;
                int [] dirr={-1,0,+1,0};
                int [] dirc={0,+1,0,-1};
                for(int i=0;i<4;i++){
                    int tempr=dirr[i]+r;
                    int tempc=dirc[i]+c;
                    if(tempr>=0 && tempc>=0 && tempr< n && tempc<m && grid[tempr][tempc]==1 && vis[tempr][tempc]==-1){
                        vis[tempr][tempc]=1;
                        q.offer(new pair(tempr,tempc));
                    }

                }
            }

        }
        if(recheck==t) return res-1;
        else return -1;
        
    }
}
