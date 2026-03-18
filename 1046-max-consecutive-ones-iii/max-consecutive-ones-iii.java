class Solution {
    public int longestOnes(int[] nums, int k) {
        // maximum length sunbarray with at most k 0 
        int i=0,j=0;
        int max=Integer.MIN_VALUE;
        int zero=0;

        while(j<nums.length){
            if(nums[j]==0) zero++;
            while(i<=j && zero>k){
                if(nums[i]==0) zero--;
                i++;
            }

            max=Math.max(max,j-i+1);
            j++;
        }
        return max;
    }
}