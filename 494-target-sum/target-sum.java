class Solution {
    
    public int findTargetSumWays(int[] arr, int target1) {
        int sum=0;
        for(int num:arr){
            sum+=num;
        }
        int target=(target1+sum)/2;
        if(target1>sum || (target1+sum)%2!=0|| target<0) return 0;
        
        Integer dp[][]=new Integer[arr.length+1][target+1];

        for(int i=1;i<=target;i++){
            dp[0][i]=0;
        }
        dp[0][0]=1;
        
        
        for(int i=1;i<=arr.length;i++){
            for(int j=0;j<=target;j++){
                if(arr[i-1]<=j){
                    dp[i][j]=dp[i-1][j-arr[i-1]]+dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        
        return dp[arr.length][target];
    }
}