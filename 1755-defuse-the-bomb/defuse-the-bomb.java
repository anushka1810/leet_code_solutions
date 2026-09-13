class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] code2 = new int[2*code.length];
        int n = code.length,csum=0;

        int sum[] = new int[code.length];
        if(k==0) return sum;

        for(int i=0;i<n;i++){
            code2[i] = code[i];
            code2[i+n] = code[i];
        }

        int i=0,j=0;

        while(i<n){
            csum+=code2[j];

            if(j-i+1<Math.abs(k)){
                j++;
            }else if(j-i+1 == Math.abs(k)){
                sum[i] = csum;
                csum-=code2[i];
                i++;
                j++;

            }
        }
        int ans[] = new int[n];


        for(int z=0;z<n;z++){
            if(k>0){
                int idx=(z+1+n)%n;
                ans[z]=sum[idx];

            }else{
                int k1=Math.abs(k);
                int idx=(z-k1+n)%n;
                ans[z]=sum[idx];
            }
            
        }

        return ans;
    }
}