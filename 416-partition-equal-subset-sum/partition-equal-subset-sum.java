class Solution {
    public boolean isSubsetSum(int arr[], int sum) {
        // code here
        
        
        Boolean dp[][]=new Boolean[arr.length+1][sum+1];
        
        // return helper(arr,sum,arr.length-1,dp);
        
        for(int i=0;i<=arr.length;i++){
            dp[i][0]=true;
        }
        for(int i=1;i<=sum;i++){
            dp[0][i]=false;
        }
        
        
        for(int i=1;i<=arr.length;i++){
            for(int j=1;j<=sum;j++){
                if(arr[i-1]<=j){
                    dp[i][j]=dp[i-1][j-arr[i-1]]||dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        
        return dp[arr.length][sum];
        
        
    }
    public boolean canPartition(int[] nums) {
        int total=0;
        for(int num:nums){
            total+=num;
        }

        if(total%2!=0) return false;

        return isSubsetSum(nums,total/2);

    }
}