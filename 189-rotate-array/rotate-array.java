class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            int index=(i+k)%n;
            ans[index]=nums[i];
        }

        for(int i=0;i<n;i++){
            nums[i]=ans[i];
        }
    }
}