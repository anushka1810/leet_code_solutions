class Solution {
    public boolean selfdividing(int num){
        int c=num;
        int count=0,size=0;
        while(c!=0){
            int b=c%10;
            if(b==0){
                return false;
            }
            if(num%b==0){
                count++;
            }
            c=c/10;
            size++;
        }
        if(size==count){
            return true;
        }
        return false;
    }
    public List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> h=new ArrayList<Integer>();
        for(int i=left;i<=right;i++){
            if(selfdividing(i)){
                h.add(i);
            }
        }
        return h;
    }
}