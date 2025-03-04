class Solution {
    public boolean detectCapitalUse(String word) {
        char wordarr[]=word.toCharArray();
        int capletter=0;
        int smletter=0;
        int invalidletter=0;
        for(int i=0;i<wordarr.length;i++){
            if(wordarr[i]>=65 && wordarr[i]<=90){
                capletter++;
            }else if(wordarr[i]>=97 && wordarr[i]<=122){
                smletter++;
            }else{
                invalidletter++;
            }
        }
        if(capletter==wordarr.length || smletter==wordarr.length){
            return true;
        }
        if(capletter==1 && smletter==wordarr.length-1){
            if(wordarr[0]>=65 && wordarr[0]<=90){
                return true;
            }
        }
        return false;
    }
}