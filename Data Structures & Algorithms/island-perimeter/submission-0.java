class Solution {

    public void bfs(int i, int j, int[][] vis, int[][] grid, int[] res) {

        int n = grid.length;
        int m = grid[0].length;

        vis[i][j] = 1;

        int[] dirr = {-1, 0, 1, 0};
        int[] dirc = {0, 1, 0, -1};

        int count = 0;

        for(int k = 0; k < 4; k++) {

            int tempr = dirr[k] + i;
            int tempc = dirc[k] + j;

            if(tempr >= 0 && tempc >= 0 &&
               tempr < n && tempc < m &&
               grid[tempr][tempc] == 1) {

                if(vis[tempr][tempc] == -1) {
                    bfs(tempr, tempc, vis, grid, res);
                }

                count++;
            }
        }

        res[0] = res[0] + (4 - count);
    }

    public int islandPerimeter(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];

        for(int i = 0; i < n; i++) {
            Arrays.fill(vis[i], -1);
        }

        int[] res = new int[1];

        for(int i = 0; i < n; i++) {

            for(int j = 0; j < m; j++) {

                if(grid[i][j] == 1) {

                    if(vis[i][j] == -1) {

                        bfs(i, j, vis, grid, res);

                        break;
                    }
                }
            }
        }

        return res[0];
    }
}