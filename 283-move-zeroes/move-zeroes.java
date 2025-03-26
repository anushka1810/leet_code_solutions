class Solution {
    public void moveZeroes(int[] nums){
        if(nums.length==1){
            System.out.println(nums[0]);
        }
        else{
            int arr[]=new int[nums.length];
            int j=0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]!=0){
                    arr[j]=nums[i];
                    j++;
                }
            }
            for(int i=0;i<j;i++){
                nums[i]=arr[i];
            }
            for(int i=j;i<nums.length;i++){
                nums[i]=arr[i];
            }
        }
    }
}