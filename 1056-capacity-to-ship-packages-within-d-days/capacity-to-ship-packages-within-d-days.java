class Solution {
    public int solve(int[]weights,int mid,int days){
        int day=1;
        int sum=0;

        for(int num:weights){
            if(sum+num>mid){
                day++;
                sum=num;
            }else{
                sum+=num;
            }
        }
        return day;
    }
    public int shipWithinDays(int[] weights, int days) {
        int max=Integer.MIN_VALUE;
        int sum=0;

        for(int num:weights){
            if(num>max) max=num;
            sum+=num;
        }

        int low=max,high=sum;
        int ans=0;

        while(low<=high){
            int mid=low+(high-low)/2;

            int mindayReq=solve(weights,mid,days);

            if(mindayReq>days){
                low=mid+1;
            }else{
                ans=mid;
                high=mid-1;
            }
        }
        return ans;
        
    }
}