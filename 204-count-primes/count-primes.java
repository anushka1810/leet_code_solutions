class Solution {
    public int countPrimes(int n) {
        int count=0;
        boolean Sieve[]=new boolean[n];
        Arrays.fill(Sieve,true);
        for(int i=2;i*i<n;i++){
            if(Sieve[i]){
                for(int j=i*i;j<n;j+=i){
                    Sieve[j]=false;
                }
            }
        }


        for(int i=2;i<n;i++){
            if(Sieve[i]) count++;
        }

        return count;

    }
}