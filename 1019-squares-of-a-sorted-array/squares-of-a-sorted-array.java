class Solution {
    public int[] sortedSquares(int[] nums) {
        int num1[]=new int[nums.length];
        int z=0;
        while(z<nums.length){
            num1[z]=nums[z]*nums[z];
            z++;
        }
        Arrays.sort(num1);
        return num1;        
    }
}