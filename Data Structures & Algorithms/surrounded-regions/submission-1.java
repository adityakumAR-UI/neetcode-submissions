class Solution {
    class pair{
        int r;int c;
        pair(int r,int c){
            this.r=r;
            this.c=c;
        }
    }
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        int [][] vis=new int [n][m];
        for(int i=0;i<n;i++) Arrays.fill(vis[i],-1);
        Queue<pair> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((i==0 || j==0 || i==n-1 || j==m-1 ) && (board[i][j]=='O')){
                    q.offer(new pair(i,j));
                    vis[i][j]=1;

                }
            }
            
        }
        while(q.size()>0){
            pair p=q.poll();
            int r=p.r;
            int c=p.c;
            int [] dirr={-1,0,+1,0};
            int [] dirc={0,+1,0,-1};
            for(int k=0;k<4;k++){
                int tempr=r+dirr[k];
                int tempc=c+dirc[k];
                if(tempr>=0 && tempc>=0 && tempr<n && tempc<m && board[tempr][tempc]=='O' && vis[tempr][tempc]==-1){
                    q.offer(new pair(tempr,tempc));
                    vis[tempr][tempc]=1;
                }

            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==-1 && board[i][j]=='O') board[i][j]='X';
            }
        }
        return ;
        
    }
}
