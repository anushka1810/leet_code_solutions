class Solution {
    public int thirdMax(int[] nums) {
        HashSet<Integer> h=new HashSet<>();
        int count=0,k=0;
        for(int i:nums){
            if(h.contains(i)){
                continue;
            }
            h.add(i);
            count++;
        }
        int arr[]=new int[h.size()];
        int p=0;
        for(int ele:h){
            arr[p++]=ele;
        }
        Arrays.sort(arr);
        if(arr.length<3){
            return arr[arr.length-1];
        }
        return arr[arr.length-3];
    }
}