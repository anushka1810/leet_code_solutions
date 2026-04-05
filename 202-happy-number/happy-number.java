class Solution {
    public boolean isHappy(int n) {
       HashSet<Integer> h=new HashSet<>();

       while(!h.contains(n)){
        h.add(n);
        if(n==1) return true;
        int n1=n;
        int sum=0;
        while(n1>0){
            int b=(n1%10);
            sum+=(b*b);
            n1=n1/10;
        }
        n=sum;

       }
       return false;
    }
}