class Solution {
    public boolean helper(int[] nums,int i,int j,int score1,int score2,int ChanceOf1,Boolean dp[][][][][]){
        if(j<i){
            if(score1>score2){
                return true;
            }
            else return false;
        }

        if(dp[i][j][score1][score2][ChanceOf1]!=null) return dp[i][j][score1][score2][ChanceOf1];


        if(ChanceOf1==1){
            return dp[i][j][score1][score2][ChanceOf1]=helper(nums,i+1,j,score1+nums[i],score2,1-ChanceOf1,dp)||helper(nums,i,j-1,score1+nums[j],score2,1-ChanceOf1,dp);
        }else{
            return dp[i][j][score1][score2][ChanceOf1]=helper(nums,i+1,j,score1,nums[i]+score2,1-ChanceOf1,dp) && helper(nums,i,j-1,score1,nums[j]+score2,1-ChanceOf1,dp);
        }
    }
    public boolean stoneGame(int[] piles) {
        // int n=piles.length;
        // int sum=0;
        // for(int num:piles) sum+=num;
        // Boolean dp[][][][][]=new Boolean[n][n][sum][sum][2];
        // return helper(piles,0,n-1,0,0,1,dp);
        return true;
    }
}