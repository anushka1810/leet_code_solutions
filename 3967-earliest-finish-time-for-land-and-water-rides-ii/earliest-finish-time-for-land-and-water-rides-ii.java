class Solution {
    public long solve(int FrStart[],int FsDur[],int SrStart[],int SrDur[]){
        long min=Long.MAX_VALUE;
        for(int i=0;i<FrStart.length;i++){
            min=Math.min(min,FrStart[i]+FsDur[i]);
        }

        long minTotal=Long.MAX_VALUE;
        for(int i=0;i<SrStart.length;i++){
            minTotal=Math.min(minTotal,Math.max(min,SrStart[i])+SrDur[i]);

        }

        return minTotal;
    }
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {

        return (int)Math.min(solve(landStartTime,landDuration,waterStartTime,waterDuration),solve(waterStartTime,waterDuration,landStartTime,landDuration));
        
    }
}