class Solution {
    public boolean isValidSerialization(String preorder) {
        String arr[]=preorder.split(",");
        int slot=1;
         for(String ch:arr){
            slot--;

            if(slot<0) return false;
            if(!ch.equals("#")) slot+=2;
         }

        return slot==0;
        
    }
}