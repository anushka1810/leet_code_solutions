class Solution {
    public boolean checkPerfectNumber(int num) {
        int sum_div=0;
        int i=1;
        while(i<num){
            if(num%i==0){
                sum_div=sum_div+i;
            }
            i++;
        }
        if(sum_div==num){
            return true;
        }
        return false;
    }
}