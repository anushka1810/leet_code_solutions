class Solution {
    public void dfs(int i,int j,int r,int c,boolean visited[][],int directions[][],int[][] grid){
        visited[i][j]=true;

        for(int dir[]:directions){
            int ni=i+dir[0];
            int nj=j+dir[1];

            if(ni>=0 && nj>=0 && ni<r && nj<c && grid[ni][nj]==0 && !visited[ni][nj]){
                dfs(ni,nj,r,c,visited,directions,grid);
            }
        }
    }
    public int closedIsland(int[][] grid) {
        int r=grid.length;
        int c=grid[0].length;
        boolean visited[][]=new boolean[r][c];
        int[][] directions={{1,0},{0,1},{-1,0},{0,-1}};
        int comp=0;
        int total=0;


        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(i==0||j==0||i==r-1||j==c-1){
                    if(grid[i][j]==0 && !visited[i][j]){
                        comp++;
                        dfs(i,j,r,c,visited,directions,grid);
                    }
                }
            }
        }

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==0 && !visited[i][j]){
                    total++;
                    dfs(i,j,r,c,visited,directions,grid);
                }
            }
        }


        return total;
        
    }
}