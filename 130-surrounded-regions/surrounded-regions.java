class Solution {
    public void dfs(int i,int j,char[][] board,int m,int n,int[][] direction){

        board[i][j]='#';

        for(int[] dir:direction){
            int ni=i+dir[0];
            int nj=j+dir[1];

            if(ni>=0 && nj>=0 && ni<m && nj<n && board[ni][nj]=='O'){
                dfs(ni,nj,board,m,n,direction);
            }
        }
    }
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;

        int direction[][]={{1,0},{-1,0},{0,1},{0,-1}};

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((i==0 || j==0 || i==m-1 || j==n-1) && board[i][j]=='O'){
                    dfs(i,j,board,m,n,direction);
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