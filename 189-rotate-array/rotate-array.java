class Solution {
    public void rotate1(int[] arr, int i,int j){
        while(i<j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    public void rotate(int[] arr, int k) {
        int n = arr.length;
        k=k%n;
        if(k>n) return;
        rotate1(arr,0,n-1);
        rotate1(arr,0,k-1);
        rotate1(arr,k,n-1);
    }
}