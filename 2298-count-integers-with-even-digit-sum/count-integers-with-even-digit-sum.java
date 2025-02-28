class Solution {
    public int countEven(int num) {
        int count=0;
        for(int i=1;i<=num;i++){
            int c=i;
            int sum1=0;
            while(c!=0){
                int b=c%10;
                sum1=sum1+b;
                c=c/10;
            }
            if(sum1%2==0){
                count++;
            }
        }
        return count;
    }
}