class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int sum=0,j=1,count=0;
        int nums[]=new int[num_people];
        while(count<candies){
            for(int i=0;i<nums.length;i++){
                if(candies<=sum){
                    break;
                }
                if(candies-sum>=j){
                    nums[i]+=j;
                }else{
                    nums[i]+=(candies-sum);
                }
                sum+=j;
                j++;
            }
            count=sum;
        }
        return nums;
    }
}