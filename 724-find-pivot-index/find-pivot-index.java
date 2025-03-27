class Solution {
    public int cs(int[] nums,int index,String s){
        int ls=0,rs=0;
        for(int i=0;i<index;i++){
            ls+=nums[i];
        }
        for(int i=index+1;i<nums.length;i++){
            rs+=nums[i];
        }
        if(s=="left"){
            return ls;
        }
        return rs;
    }
    public int pivotIndex(int[] nums) {
        int leftsum=0;
        int rightsum=0;
        for(int i=0;i<nums.length;i++){
            if(i==0){
                leftsum=0;
            }else{
                leftsum=cs(nums,i,"left");
            }
            if(i==nums.length-1){
                rightsum=0;
            }else{
                rightsum=cs(nums,i,"right");
            }
            if(leftsum==rightsum){
                return i;
            }
        }
        return -1;
    }
}