class Solution {
    public int solve(int FrStart[],int FsDur[],int SrStart[],int SrDur[]){
        int min=Integer.MAX_VALUE;
        for(int i=0;i<FrStart.length;i++){
            min=Math.min(min,FrStart[i]+FsDur[i]);
        }

        int minTotal=Integer.MAX_VALUE;
        for(int i=0;i<SrStart.length;i++){
            if(SrStart[i]<=min){
                minTotal=Math.min(minTotal,min+SrDur[i]);
            }else{
                minTotal=Math.min(minTotal,SrStart[i]+SrDur[i]);
            }

        }

        return minTotal;
    }
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {

        return Math.min(solve(landStartTime,landDuration,waterStartTime,waterDuration),solve(waterStartTime,waterDuration,landStartTime,landDuration));
        
    }
}