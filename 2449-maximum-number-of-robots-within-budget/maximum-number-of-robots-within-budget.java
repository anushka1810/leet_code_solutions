class Solution {
    // public int budgetReqToTakeMidSub(long budget,int[] arrC, int[] arrR){
    //     int i=0,j=0;
    //     // int max=arr[0];
    //     ArrayDeque<Integer> max=new ArrayDeque<>();
    //     long sum=0;
    //     long minBudget=Long.MAX_VALUE;
    //     // int k=mid;
    //     int ans=0;

    //     while(j<arrR.length){
    //         while(!max.isEmpty() && max.getLast()<arrC[j]) max.pollLast();
    //         max.add(arrC[j]);
    //         sum+=arrR[j];

    //         while(i<=j && (max.peek()+(long)(j-i+1)*sum)>budget){
    //             sum-=arrR[i];
    //             if(arrC[i]==max.peek()) max.pollFirst();
    //             i++;
    //         }

    //         if( i<=j && (max.peek()+(long)(j-i+1)*sum)<=budget) ans=Math.max(ans,j-i+1);
    //         j++;
    //     }
    //     return ans;
    // }
    // public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {

    //     return budgetReqToTakeMidSub(budget,chargeTimes,runningCosts);
        
    // }
    public boolean check(int[] chargeTimes, int[] runningCosts, long budget,int k){

        if(k==0) return true;
        int i=0,j=0;
        long sum=0;
        ArrayDeque<Integer> dq=new ArrayDeque<>();

        while(j<chargeTimes.length){
            sum+=runningCosts[j];
            while(!dq.isEmpty() && dq.peekLast()<chargeTimes[j]){
                dq.pollLast();
            }
            dq.addLast(chargeTimes[j]);

            if(j-i+1==k){
                long budReq=(long)dq.peek()+(long)(k*sum);
                if(budReq<=budget) return true;

                if(dq.peek()==chargeTimes[i]){
                    dq.pollFirst();
                }
                sum-=runningCosts[i];
                i++;
            }
            j++;
        }
        return false;
    }
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {

        int low=0,high=chargeTimes.length;
        int ans=0;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(check(chargeTimes,runningCosts,budget,mid)){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;


        
    }
}