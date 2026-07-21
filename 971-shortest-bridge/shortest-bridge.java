class Solution {
    public int dfs(int i,int j,int count,boolean[][] visited,int[] grid[],int[][] directions,int r,int c){
        visited[i][j]=true;
        grid[i][j]=count;

        int ans=1;
        for(int[] dir:directions){
            int ni=i+dir[0];
            int nj=j+dir[1];

            if(ni>=0 && nj>=0 && ni<r && nj<c && grid[ni][nj]==1 && !visited[ni][nj]){
                ans+=dfs(ni,nj,count,visited,grid,directions,r,c);
            }
        }
        return ans;
    }
    public int shortestBridge(int[][] grid) {
        int r=grid.length;
        int c=grid[0].length;
        int count=1;
        boolean visited[][]=new boolean[r][c];
        int[][] directions={{0,1},{1,0},{0,-1},{-1,0}};
        int min=Integer.MAX_VALUE;
        int ele=0;


        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    int size=dfs(i,j,count,visited,grid,directions,r,c);
                    if(size<min){
                        min=size;
                        ele=count;
                    }
                    count++;
                }
            }
        }

        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==ele){
                    q.add(new int[]{i,j,0});
                }
            }
        }


        boolean[][] visited2=new boolean[r][c];
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] details=q.poll();
                for(int[] dir:directions){

                    int ni=details[0]+dir[0];
                    int nj=details[1]+dir[1];
                    int dis=details[2];

                    if(ni>=0 && nj>=0 && ni<r && nj<c && !visited2[ni][nj]){
                        if(ele==1 && grid[ni][nj]==2) return dis;
                        if(ele==2 && grid[ni][nj]==1) return dis;
                        
                        visited2[ni][nj]=true;
                        q.add(new int[]{ni,nj,dis+1});
                        
                    }    
                }
            }
        }


        return -1;

    
        
    }
}