class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int newmat[][]=new int[r][c];
        if(r*c!=mat.length*mat[0].length){
            return mat;
        }
        int col=0,row=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(col < mat[0].length){
                    newmat[i][j]=mat[row][col];
                    col++;
                }else{
                    col=0;
                    row++;
                    newmat[i][j]=mat[row][col];
                    col++;
                }
            }
        }
        return newmat;





    }
}