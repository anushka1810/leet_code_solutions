class Solution {
    public int helper(int [] nums,int idx,int[] dp,int end){
        if(idx>=end){
            return 0;
        }
        if(dp[idx]!=-1) return dp[idx];
        int take=helper(nums,idx+2,dp,end)+nums[idx];
        int notake=helper(nums,idx+1,dp,end);

        return dp[idx]=Math.max(take,notake);

    }
    public int rob(int[] nums) {

        if(nums.length==1) return nums[0];

        int dp1[]=new int[nums.length];
        Arrays.fill(dp1,-1);
        int dp2[]=new int[nums.length];
        Arrays.fill(dp2,-1);
        int op1=helper(nums,0,dp1,nums.length-1);
        int op2=helper(nums,1,dp2,nums.length);

        //System.out.println(op1+" "+op2);

        return Math.max(op1,op2);
        
    }
}