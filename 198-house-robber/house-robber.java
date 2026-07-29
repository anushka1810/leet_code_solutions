class Solution {
    public int helper(int [] nums,int idx,int[] dp){
        if(idx>=nums.length){
            return 0;
        }
        if(dp[idx]!=-1) return dp[idx];
        int take=helper(nums,idx+2,dp)+nums[idx];
        int notake=helper(nums,idx+1,dp);

        return dp[idx]=Math.max(take,notake);

    }
    public int rob(int[] nums) {

        int dp[]=new int[nums.length];
        Arrays.fill(dp,-1);
        return helper(nums,0,dp);
        
    }
}