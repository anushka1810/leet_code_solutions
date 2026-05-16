class Solution {
    public int findMin(int[] arr) {

        int n=arr.length;
        int low=0,high=n-1;

        while(low<=high){
            int mid=low+(high-low)/2;
            
            if(arr[mid]>arr[high]){
                low=mid+1;
            }else if(arr[mid]<arr[high]){
                high=mid;
            }else high--;

        }
        return arr[low];
        
    }
}