class Solution {
    // class Pair{
    //     int prev;
    //     int idx;
    //     Pair(int prev,int idx){
    //         this.prev=prev;
    //         this.idx=idx;
    //     }
    // }
    public int upperBound(int[] arr,int val){
        int low=0,high=arr.length-1;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;

            if(arr[mid]>val){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return ans;
    }

    public long helper(int arr1[],int[] arr2,int prev,int idx,HashMap<String,Long> h){
        if(idx==arr1.length) return 0;

        // Pair p=new Pair(prev,idx);

        String p=prev+"#"+idx;
        if(h.containsKey(p)) return h.get(p);
        long res=Integer.MAX_VALUE;
        if(arr1[idx]>prev){
            // hmre pass option hai ki hum iss elemnet ko change kre ya nhi 
            //nhi replace kiya age bdh gye 
            res=Math.min(res,helper(arr1,arr2,arr1[idx],idx+1,h));
        }
        //replace kr diya
        int indexToWhomReplace=upperBound(arr2,prev);

        if(indexToWhomReplace!=-1) res=Math.min(res,1+helper(arr1,arr2,arr2[indexToWhomReplace],idx+1,h));

        h.put(p,res);
        return res;
    }

    
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);
        // HashMap<Pair,Long> h=new HashMap<>();
        HashMap<String,Long> h=new HashMap<>();
        long value = helper(arr1,arr2,-1,0,h);

        if(value>=Integer.MAX_VALUE) return -1;
        return (int)value;

    }
}