class Solution {
    public boolean checkRecord(String s) {
        char a[]=s.toCharArray();
        int absentDay=0;
        for(int i=0;i<a.length;i++){
            if(a[i]=='A'){
                absentDay++;
            }
            if(i!=0 && i!=a.length-1 && a[i]=='L' && a[i+1]=='L' && a[i-1]=='L'){
                return false;
            }
        }
        if(absentDay>=2){
            return false;
        }
        return true;
    }
}