class Solution {
    public int longestOnes(int[] nums, int k) {
        int i=0,j=0;
        int n=nums.length;
        int zero=0;
        int ans=0;

        while(j<n){
            if(nums[j]==0) zero++;

            while(i<=j && zero>k){
                if(nums[i]==0) zero--;
                i++;
            }

            if(zero<=k) ans=Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}