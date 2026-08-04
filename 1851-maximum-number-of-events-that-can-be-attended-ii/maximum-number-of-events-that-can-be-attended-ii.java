class Solution {

    public int upperBound(int[][] arr,int val){

        int low=0,high=arr.length-1;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;


            if(arr[mid][0]>val){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        if(ans==-1) return arr.length;
        return ans;

    }

    public int helper(int[][] events,int idx,int k,Integer[][] dp){
        if(k==0 || idx==events.length){
            return 0;
        }

        if(dp[idx][k]!=null) return dp[idx][k];

        int taken=helper(events,upperBound(events,events[idx][1]),k-1,dp)+events[idx][2];

        int nontaken=helper(events,idx+1,k,dp);

        return dp[idx][k]=Math.max(taken,nontaken);
    }

    public int maxValue(int[][] events, int k) {
        int n=events.length;
        Arrays.sort(events,(a,b)->{
            return a[0]==b[0]?a[1]-b[1]:a[0]-b[0];
        });


        Integer dp[][]=new Integer[n+1][k+1];

        return helper(events,0,k,dp); 
    }
}