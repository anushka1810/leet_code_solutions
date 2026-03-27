class Solution {
    public int majorityElement(int[] nums) {
        int ele=nums[0];
        int count=1;

        for(int i=1;i<nums.length;i++){
            if(count==0){
                ele=nums[i];
                count++;
                continue;
            }
            if(nums[i]!=ele){
                count--;
            }else{
                count++;
            }
        }


        int freq=0;
        for(int num:nums){
            if(num==ele) freq++;
        }
        if(freq>=(nums.length)/2) return ele;
        return -1;
    }
}