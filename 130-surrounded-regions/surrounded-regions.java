class Solution {
    public void dfs(int i,int j,char[][] board,boolean[][] visited,int m,int n,int[][] direction){
        visited[i][j]=true;

        board[i][j]='#';

        for(int[] dir:direction){
            int ni=i+dir[0];
            int nj=j+dir[1];

            if(ni>=0 && nj>=0 && ni<m && nj<n && !visited[ni][nj] && board[ni][nj]=='O'){
                dfs(ni,nj,board,visited,m,n,direction);
            }
        }
    }
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;

        Queue<Integer> q=new LinkedList<>();
        boolean visited[][]=new boolean[m][n];
        int direction[][]={{1,0},{-1,0},{0,1},{0,-1}};

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((i==0 || j==0 || i==m-1 || j==n-1)&& !visited[i][j] && board[i][j]=='O'){
                    dfs(i,j,board,visited,m,n,direction);
                }
            }
        }


        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='#'){
                    board[i][j]='O';
                }
            }
        }

    }
}