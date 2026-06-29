class Solution {
    public int[] nse(int[] arr){
        int n=arr.length;
        Stack<Integer> st=new Stack<>();

        int[] nse=new int[n];

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }

            if(st.isEmpty()){
                nse[i]=-1;
            }else{
                nse[i]=st.peek();
            }
            st.push(i);

        }
        return nse;
    }
    public int[] pse(int[] arr){
        int n=arr.length;
        Stack<Integer> st=new Stack<>();

        int[] pse=new int[n];

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }

            if(st.isEmpty()){
                pse[i]=-1;
            }else{
                pse[i]=st.peek();
            }
            st.push(i);
        }
        return pse;
    }
    public int sumSubarrayMins(int[] arr) {
        long MOD=1000_000_007;
        int n=arr.length;
        int[] nse=nse(arr);
        int[] pse=pse(arr);
        long sum=0;
        for(int i=0;i<n;i++){
            int l=0;
            int r=0;
            if(pse[i]==-1){
                l=i+1;
            }else{
                int k=pse[i];
                l=(i-k);
            }
            if(nse[i]==-1){
                r=n-1-i+1;
            }else{
                int k=nse[i];
                r=(k-1-i+1);
            }

            sum=(sum+(1L*arr[i]*l*r)%MOD)%MOD;
        }

        return (int)sum;
        
    }
}