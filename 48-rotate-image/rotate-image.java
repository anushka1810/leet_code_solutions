class Solution {
    public void reverse(int[] matrix){
        int n=matrix.length;
        for(int i=0;i<n/2;i++){
            int temp=matrix[i];
            matrix[i]=matrix[n-i-1];
            matrix[n-i-1]=temp;
        }
    }
    public void Transpose(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=i;j<matrix[i].length;j++){
                if(i==j) continue;
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
    }
    public void rotate(int[][] matrix) {
        
        Transpose(matrix);     //caution ---tricky hai doublle swapp  na ho 
        for(int i=0;i<matrix.length;i++){
            reverse(matrix[i]);
        }
    }
}