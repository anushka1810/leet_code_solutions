class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean Sieve[]=new boolean[right+1];
        Arrays.fill(Sieve,true);

        Sieve[0]=false;
        Sieve[1]=false;
        for(int i=2;i<=right;i++){
            if(Sieve[i]){

                for(int j=i*i;j<=right && (long)i*i<=right;j+=i){
                    Sieve[j]=false;
                }
            }
        }

        long ans=Long.MAX_VALUE;
        long ansL=-1,ansR=-1;
        long l=-1;
        for(long l1=left;l1<=right && (long)l1<=right;l1++){
            if(Sieve[(int)l1]){
                l=l1;
                break;
            }
        }
        if(l==-1) return new int[]{-1,-1};
        for(long r=l+1;r<=right && (long)r<=right;r++){
            if(Sieve[(int)r]){
                if(r-l<ans){
                    ansL=l;
                    ansR=r;
                    ans=r-l;
                }
                l=r;
            }
        }

        return new int[]{(int)ansL,(int)ansR};
    }
}