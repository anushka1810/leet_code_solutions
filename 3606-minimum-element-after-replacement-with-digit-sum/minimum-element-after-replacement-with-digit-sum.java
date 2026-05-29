class Solution {
    public int cal(int num){
        int sum=0;
        while(num!=0){
            sum+=num%10;
            num=num/10;
        }
        return sum;
    }
    public int minElement(int[] nums) {
        int min=Integer.MAX_VALUE;
        for(int num:nums){
            int val=cal(num);
            if(val<min) min=val;

        }
        return min;
        
    }
}