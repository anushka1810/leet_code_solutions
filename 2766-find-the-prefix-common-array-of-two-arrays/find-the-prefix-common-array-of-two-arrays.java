class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] freq=new int[A.length+1];
        int[] ans=new int[A.length];
        int count=0;

        for(int idx=0;idx<A.length;idx++){
            freq[A[idx]]++;
            if(freq[A[idx]]==2) count++;
            freq[B[idx]]++;
            if(freq[B[idx]]==2) count++;

            ans[idx]=count;
        }
        return ans;




    }
}