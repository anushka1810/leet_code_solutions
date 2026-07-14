class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
       int[] segment=new int[1001];
       int max=0;

       for(int[] trip:trips){
        int number=trip[0];
        int from=trip[1];
        int to=trip[2];

        segment[from]+=number;
        segment[to]-=number;
        if(to>max) max=to;
       }

       int prefix=0;
       for(int i=0;i<=max;i++){
        prefix+=segment[i];
        if(prefix>capacity) return false;
       }
       return true;
    }
}