// class Solution {
//     public int maxSubarraySumCircular(int[] nums) {
//         int n=nums.length-1;
//         int idx=0;
//         boolean isRev=false;
//         int max=Integer.MIN_VALUE;
//         int currSum=0;
//         int start=0;
//         while(start!=idx){
//             if(currSum+nums[idx]<nums[idx]){
//                 start=idx;
//                 currSum=nums[idx];
//             }else{
//                 currSum+=nums[idx];
//             }

//             max=Math.max(max,)
//         }

//         while(idx!=n-2 || !isRev){

//             currSum=Math.max(currSum+nums[idx],nums[idx]);
//             max=Math.max(max,currSum);
//             if(idx==n-1) isRev=true;
//             idx=(idx+1)%n;

//         }
//         return max;


//     }
// }


class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int total=0;
        int currmin=0;
        int currmax=0;
        for(int num:nums){
            currmin=Math.min(currmin+num,num);
            currmax=Math.max(currmax+num,num);
            total+=num;
            min=Math.min(currmin,min);
            max=Math.max(currmax,max);
        }
        if(max<0) return max;

        return Math.max(max,total-min);
    }
}