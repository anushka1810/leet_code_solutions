class Solution {
    public boolean divideArray(int[] nums) {
        if(nums.length%2!=0){
            return false;
        }else{
            for(int i=0;i<nums.length;i++){
                int j=0,count=0;
                while(j<nums.length){
                    if(nums[i]==nums[j]){
                        count++;
                    }
                    j++;
                }
                if(count%2!=0){
                    return false;
                }
            }
        }
        return true;
    }
}