class Solution {
    public boolean isValid(int n,int r,int c,boolean[] col,boolean[] leftD,boolean rightD[]){
        if(col[c]) return false;
        if(leftD[r+c]) return false;
        if(rightD[r-c+n-1]) return false;

        return true;
    }
    public void solve(int n,char[][] board,int r,List<List<String>> ans,boolean[] col,boolean[] leftD,boolean rightD[]){
        if(r==board.length){
            List<String> temp=new ArrayList<>();
            for(int i=0;i<board.length;i++){
                StringBuilder s=new StringBuilder();

                for(int j=0;j<board[i].length;j++){
                    s.append(board[i][j]);
                }
                temp.add(s.toString());
            }
            ans.add(temp);
            return;
        }
        for(int c=0;c<n;c++){    
            if(isValid(n,r,c,col,leftD,rightD)){
                board[r][c]='Q';
                col[c]=true;
                leftD[r+c]=true;
                rightD[r-c+n-1]=true;
                solve(n,board,r+1,ans,col,leftD,rightD);
                col[c]=false;
                leftD[r+c]=false;
                rightD[r-c+n-1]=false;
                board[r][c]='.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }

        boolean col[]=new boolean[n];
        boolean leftD[]=new boolean[2*n-1];
        boolean rightD[]=new boolean [2*n-1];
        solve(n,board,0,ans,col,leftD,rightD);
        return ans;
    }
}