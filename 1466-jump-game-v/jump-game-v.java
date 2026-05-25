class Solution {
    public int helper(int[] arr,int d,int indexAt,int[] dp){
        // if(d==0) return 0;
        // if(indexAt>=arr.length || indexAt<0) return 0;
        // if(arr[indexAt]>=arr[commingFrom]) return 0;


        int tempansl=0;
        int tempansr=0;
        if(dp[indexAt]!=-1) return dp[indexAt];
        for(int i=1;i<=d;i++){
            if(indexAt+i>=arr.length || arr[indexAt+i]>=arr[indexAt]) break;
            tempansl=Math.max(tempansl,helper(arr,d,indexAt+i,dp));        
        }

        for(int i=1;i<=d;i++){
            if(indexAt-i<0 || arr[indexAt-i]>=arr[indexAt]) break;
            tempansr=Math.max(tempansr,helper(arr,d,indexAt-i,dp));        
        }

        return dp[indexAt]=1+Math.max(tempansl,tempansr);
    }
    public int maxJumps(int[] arr, int d) {
        int ans=Integer.MIN_VALUE;

        int dp[]=new int[arr.length];
        Arrays.fill(dp,-1);

        for(int i=0;i<arr.length;i++){
            ans=Math.max(ans,helper(arr,d,i,dp));
        }

        return ans;
    }
}