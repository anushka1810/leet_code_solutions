class Solution {
    public int minPathSum(int[][] grid) {
        int r=grid.length;
        int c=grid[0].length;
        int dp[]=new int[c];
        dp[0]=grid[0][0];
        for(int j=1;j<c;j++){
            dp[j]=dp[j-1]+grid[0][j];
        }

        for(int i=1;i<r;i++){
            dp[0]=dp[0]+grid[i][0];
            for(int j=1;j<c;j++){
                dp[j]=Math.min(dp[j]+grid[i][j],dp[j-1]+grid[i][j]);
            }
        }

        return dp[c-1];
    }
}