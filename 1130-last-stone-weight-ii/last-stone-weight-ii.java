class Solution {
    public boolean subset(Boolean dp[][],int n,int sum,int[] stones){
        if(n==0){
            if(sum==0) return true;
            else return false;
        }

        if(dp[n][sum]!=null) return dp[n][sum];

        if(stones[n-1]<=sum){
            return dp[n][sum]=subset(dp,n-1,sum-stones[n-1],stones)||subset(dp,n-1,sum,stones);
        }else{
            return dp[n][sum]=subset(dp,n-1,sum,stones);
        }
    }
    public int lastStoneWeightII(int[] stones) {
        int n=stones.length;
        int sum=0;
        for(int num:stones){
            sum+=num;
        }
        Boolean [][] dp=new Boolean[n+1][sum/2+1];
        // boolean a=subset(dp,n,sum/2,stones);

        int max=0;
        for(int j=1;j<(sum/2+1);j++){
            if(subset(dp,n,j,stones)) max=j;
        }

        return sum-2*max;




    }
}