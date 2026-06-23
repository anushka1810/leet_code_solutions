class Solution {
    public int itneSubarryBnege(int[] nums,int mid){
        int totalSum=0,subarrayCount=1;
        for(int num:nums){
            if(totalSum+num>mid){
                subarrayCount++;
                totalSum=num;
            }else{
                totalSum+=num;
            }
        }
        return subarrayCount;
    }
    public int[] maxSum(int[] nums){
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int num:nums){
            sum+=num;
            if(num>max) max=num;
        }
        return new int[]{max,sum};
    }
    public int splitArray(int[] nums, int k) {
        // condition split me contiguous jaega 
        // empty nhi ho skata hai
        // max sum woh kitna kam se kam ho sakta hai 


        if(k>nums.length) return -1;
        if(k==nums.length){
            int[] de=maxSum(nums);
            return de[0];
        }

        int[] de=maxSum(nums);
        int low=de[0],high=de[1];
        int ans=-1;

        while(low<=high){
            int mid=low+(high-low)/2;

            int KitneSubArrBnegeIssMaxSubarraySumKSth=itneSubarryBnege(nums,mid);

            if(KitneSubArrBnegeIssMaxSubarraySumKSth<=k){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}