class Solution {
    public int distributeCandies(int[] candyType) {
        int len=candyType.length;
        HashSet<Integer> h=new HashSet<>();
        int count=0;
        for(int i=0;i<len;i++){
            if(!h.contains(candyType[i])){
                h.add(candyType[i]);
                count++;
            }
        }
        if((len/2)>count){
            return count;
        }
        return len/2;
    }
}