class Solution {
    public String[] findRelativeRanks(int[] score) {
        int arr[]=score.clone();
        Arrays.sort(arr);
        String[] output=new String[score.length];
        int i=0;
        int n=score.length;
        while(i<score.length){
            int rank=0;
            for(int j=0;j<arr.length;j++){
                if(arr[j]==score[i]){
                    rank=j;
                }
            }
            if(rank==n-1){
                output[i]="Gold Medal";
            }
            else if(rank==n-2){
                output[i]="Silver Medal";
            }
            else if(rank==n-3){
                output[i]="Bronze Medal";
            }
            else{
                output[i]=String.valueOf(n-rank);
            }
            i++;
        }
        return output;

    }
}