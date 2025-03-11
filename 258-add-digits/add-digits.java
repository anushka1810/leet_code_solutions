class Solution {
    public int returnsum(int num){
        int sum=0;
        while(num!=0){
            int c=num%10;
            sum=sum+c;
            num=num/10;
        }
        return sum;
    }
    public int addDigits(int num) {
        int res=returnsum(num);
        while(res>=10){
            res=returnsum(res);
        }
        return res;
    }
}