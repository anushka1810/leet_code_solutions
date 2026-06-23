class Solution {
    public int solve(int[] nums,int mid){
        int pairFormWithMidDiff=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i+1]-nums[i]<=mid){
                pairFormWithMidDiff++;
                i++;
            }
        }
        return pairFormWithMidDiff;
    }
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int num:nums){
            if(num>max) max=num;
            if(num<min) min=num;
        }
        int low=0,high=max-min;
        int ans=0;

        while(low<=high){
            int mid=low+(high-low)/2;

            int pairFormed=solve(nums,mid);

            if(pairFormed<p){
                low=mid+1;
            }else{
                ans=mid;
                high=mid-1;
            }
        }
        return ans;




    }
}