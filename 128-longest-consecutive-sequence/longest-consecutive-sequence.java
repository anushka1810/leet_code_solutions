class Solution {
    public int longestConsecutive(int[] nums) {
        TreeMap<Integer,Integer> h=new TreeMap<>();
        for(int num:nums){
            h.put(num,1);
        }
        int max=0;
        for(int key:h.keySet()){
            if(h.containsKey(key-1)){
                h.put(key,h.get(key-1)+1);
            }
            max=Math.max(max,h.get(key));
        }
        return max;
    }
}