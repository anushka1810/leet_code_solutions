class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int largest=0;
        int i=0;
        int count=0;
        while(i<nums.length){
            if(nums[i]==1){
                count++;
            }else{
                if(count>largest){
                    largest=count;
                }
                count=0;
            }
            if(count>largest){
                largest=count;
            }
            i++;
        }
        return largest;
    }
}