class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n==1){
            return true;
        }
        else if (n%2!=0){
            return false;
        }
        else{
            if(n>0 && (n & (n-1))==0){
                return true;
            }
        }
        return false;
    }
}