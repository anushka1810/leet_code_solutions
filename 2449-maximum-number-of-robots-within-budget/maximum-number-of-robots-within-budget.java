class Solution {
    public int budgetReqToTakeMidSub(long budget,int[] arrC, int[] arrR){
        int i=0,j=0;
        // int max=arr[0];
        ArrayDeque<Integer> max=new ArrayDeque<>();
        long sum=0;
        long minBudget=Long.MAX_VALUE;
        // int k=mid;
        int ans=0;

        while(j<arrR.length){
            while(!max.isEmpty() && max.getLast()<arrC[j]) max.pollLast();
            max.add(arrC[j]);
            sum+=arrR[j];

            // long bud=max.peek()+(long)k*sum;
            while(i<=j && (max.peek()+(long)(j-i+1)*sum)>budget){
                sum-=arrR[i];
                if(arrC[i]==max.peek()) max.pollFirst();
                i++;
            }

            if( i<=j && (max.peek()+(long)(j-i+1)*sum)<=budget) ans=Math.max(ans,j-i+1);
            j++;

            // if(j-i+1<k) j++;
            // else if(j-i+1==k){
            //     if(bud<minBudget) minBudget=bud;

            // }
        }
        return ans;
    }
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        // int n=chargeTimes.length;

        // int low=1,high=n;
        // int ans=0;

        // while(low<=high){
        //     int mid=low+(high-low)/2;

        //     long b=budgetReqToTakeMidSub(mid,chargeTimes,runningCosts);
        //     if(b>budget){
        //         high=mid-1;
        //     }else{
        //         ans=mid;
        //         low=mid+1;
        //     }
        // }

        return budgetReqToTakeMidSub(budget,chargeTimes,runningCosts);
        
    }
}