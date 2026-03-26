class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n=nums.length;
        if(n<3) return 0;
        int j=2,last=0,sum=0;

        while(j<n){
            if(nums[j]-nums[j-1]==nums[j-1]-nums[j-2]){
                sum+=last+1;
                last++;
            }else{
                last=0;
            }
            j++;
        }
        return sum;
    }
}