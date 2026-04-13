class Solution {
    public int hIndex(int[] citations) {
        int n=citations.length;
        int ans[]=new int[n+1];

        for(int i=0;i<n;i++){
            if(citations[i]>n) ans[n]+=1;
            else ans[citations[i]]++;
        }
        int atleast=0;
        for(int i=n;i>=0;i--){
            atleast+=ans[i];
            if(atleast>=i) return i;
        }

        return 0;

    }
}