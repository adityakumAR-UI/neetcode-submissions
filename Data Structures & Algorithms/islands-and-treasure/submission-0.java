class Solution {

    public void dfs(int i, int j, int[][] grid) {

        int value = grid[i][j];

        int n = grid.length;
        int m = grid[0].length;

        int[] dirr = {-1, 0, +1, 0};
        int[] dirc = {0, +1, 0, -1};

        for(int k = 0; k < 4; k++) {

            int tempr = i + dirr[k];
            int tempc = j + dirc[k];

            if(tempr >= 0 &&
               tempc >= 0 &&
               tempr < n &&
               tempc < m &&
               grid[tempr][tempc] != -1) {

                if(grid[tempr][tempc] > value + 1) {

                    grid[tempr][tempc] = value + 1;

                    dfs(tempr, tempc, grid);
                }
            }
        }
    }

    public void islandsAndTreasure(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        for(int i = 0; i < n; i++) {

            for(int j = 0; j < m; j++) {

                if(grid[i][j] == 0) {

                    dfs(i, j, grid);
                }
            }
        }
    }
}