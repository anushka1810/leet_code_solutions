class Solution {
    public boolean checkunique(int[] arr) {
        HashSet<Integer> h= new HashSet<>();
        for(int y:arr){
            if(h.contains(y)){
                return false;
            }
            h.add(y);
        }
        return true;
    }
    
    public boolean canBeIncreasing(int[] nums) {
        int i=0;
        int sor[]=nums.clone();
        Arrays.sort(sor);
        if(Arrays.equals(sor,nums) && checkunique(nums)){
            return true;
        }
        while(i<nums.length){
            int b[]=new int[nums.length-1];
            int k=0;
            for(int j=0;j<nums.length;j++){
                if(i==j){
                    continue;
                }else{
                    b[k]=nums[j];
                    k++;
                }
            }
            if(checkunique(b)){
                int a[]=b.clone();
                Arrays.sort(b);
                if(Arrays.equals(a,b)){
                    return true;
                }
            }
            i++;
        }
        return false;
    }
}