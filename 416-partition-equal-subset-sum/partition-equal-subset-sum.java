class Solution {

    public Boolean solve(int[] nums,int sum,int n,Boolean[][] dp){
        if(sum==0) return true;
        if(n==0) return false;

        if(dp[n][sum]!=null) return dp[n][sum];

        if(nums[n-1]<=sum){
            return dp[n][sum]=solve(nums,sum-nums[n-1],n-1,dp)||solve(nums,sum,n-1,dp);
        }else {
            return dp[n][sum]=solve(nums,sum,n-1,dp);
        }
    }
    public boolean canPartition(int[] nums) {
        int total=0;
        for(int num:nums){
            total+=num;
        }

        if(total%2!=0){
            return false;
        }

        Boolean dp[][]=new Boolean[nums.length+1][(total/2)+1];

        return solve(nums,total/2,nums.length,dp);
    }
}