class Solution {
    public int solve(int n,int[] dp){
        if(dp[n]!=-1) return dp[n];

        int ans=0;
        for(int k=1;k<=n;k++){
            ans+=(solve(k-1,dp)*solve(n-k,dp));
        }
        dp[n]=ans;

        return dp[n];
        
    }
    public int numTrees(int n) {
        if(n==1) return 1;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);

        dp[0]=1;
        dp[1]=1;
        return solve(n,dp);

    }
}