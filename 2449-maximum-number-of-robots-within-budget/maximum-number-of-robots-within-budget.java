class Solution {
    public long budgetReqToTakeMidSub(int mid,int[] arrC, int[] arrR){
        int i=0,j=0;
        // int max=arr[0];
        ArrayDeque<Integer> max=new ArrayDeque<>();
        long sum=0;
        long minBudget=Long.MAX_VALUE;
        int k=mid;

        while(j<arrR.length){
            // if(max.isEmpty()) max.add(arrC[j]);
            // else{
                while(!max.isEmpty() && max.getLast()<arrC[j]) max.pollLast();
                max.add(arrC[j]);
            // }
            sum+=arrR[j];


            if(j-i+1<k) j++;
            else if(j-i+1==k){
                long bud=max.peek()+(long)k*sum;
                if(bud<minBudget) minBudget=bud;

                sum-=arrR[i];
                if(arrC[i]==max.peek()) max.pollFirst();
                i++;
                j++;
            }
        }
        return minBudget;
    }
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int n=chargeTimes.length;

        int low=1,high=n;
        int ans=0;

        while(low<=high){
            int mid=low+(high-low)/2;

            long b=budgetReqToTakeMidSub(mid,chargeTimes,runningCosts);
            if(b>budget){
                high=mid-1;
            }else{
                ans=mid;
                low=mid+1;
            }
        }

        return ans;
        
    }
}