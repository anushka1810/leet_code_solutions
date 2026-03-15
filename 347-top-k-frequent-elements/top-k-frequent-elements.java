class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> h=new HashMap<>();

        for(int n:nums){
            h.put(n,h.getOrDefault(n,0)+1);
        }

        ArrayList<Integer>[] bucket=new ArrayList[nums.length+1];
        for(int i=0;i<nums.length+1;i++){
            bucket[i]=new ArrayList<>();
        }

        for(int key:h.keySet()){
            bucket[h.get(key)].add(key);
        }

        int[] ans=new int[k];
        int x=0;
        for(int j=nums.length;j>=0 && k>0;j--){
            if(bucket[j].size()>0){
                for(int a:bucket[j]){
                    if(k==0) break;
                    ans[x++]=a;
                    k--;
                }
            }
        }
        return ans;
    }
}