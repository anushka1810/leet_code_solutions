class Solution {
    public boolean isValid(int n,int r,int c,boolean[] col,boolean[] leftD,boolean rightD[]){
        if(col[c]) return false;
        if(leftD[r+c]) return false;
        if(rightD[r-c+n-1]) return false;

        return true;
    }
    public int solve(int n,char[][] board,int r,boolean[] col,boolean[] leftD,boolean rightD[]){
        if(r==board.length){
            return 1;
        }
        int ans=0;
        for(int c=0;c<n;c++){    
            if(isValid(n,r,c,col,leftD,rightD)){
                board[r][c]='Q';
                col[c]=true;
                leftD[r+c]=true;
                rightD[r-c+n-1]=true;
                ans+=solve(n,board,r+1,col,leftD,rightD);
                col[c]=false;
                leftD[r+c]=false;
                rightD[r-c+n-1]=false;
                board[r][c]='.';
            }
        }
        return ans;
    }
    public int totalNQueens(int n) {
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }

        boolean col[]=new boolean[n];
        boolean leftD[]=new boolean[2*n-1];
        boolean rightD[]=new boolean [2*n-1];
        return solve(n,board,0,col,leftD,rightD);
    }
}
