class Solution {
    public int removeDuplicates(int[] nums) {
        int last=0,prev=0,i=1;
        int count=1;
        int k=1;

        while(i<nums.length){
            if(nums[last]==nums[i]){
                count++;
                if(count>=3){
                    nums[i]=Integer.MAX_VALUE;
                    // continue;
                }else{
                    last=i;
                    k++;
                }
            }else{
                prev=i;
                last=i;
                count=1;
                k++;
            }
            i++;
        }
        Arrays.sort(nums);
        return k;
    }
}