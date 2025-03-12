class Solution {
    public int missingNumber(int[] nums){        
        int len=nums.length;
        for(int i=0;i<=len;i++){
            int count=0;
            for(int j=0;j<len;j++){
                if(nums[j]==i){
                    count++;
                    continue;
                }
            }
            if(count==0){
                return i;
            }
        }
        return 0;
    }
}