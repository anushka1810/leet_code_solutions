class Solution {
    public boolean judgeCircle(String moves) {
        int countR=0,countL=0,countU=0,countD=0;
        char ch[]=moves.toCharArray();
        int i=0;
        while(i<ch.length){
            if(ch[i]=='R'){
                countR++;
            }else if(ch[i]=='L'){
                countL++;
            }else if(ch[i]=='U'){
                countU++;
            }else{
                countD++;
            }
            i++;
        }
        if(countR==countL && countU==countD){
            return true;
        }
        return false;
    }
}