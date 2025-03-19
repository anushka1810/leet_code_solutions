class Solution {
    public String isreq(String s){
        StringBuilder snew=new StringBuilder(s);
        int i=0;
        while(i<snew.length()){
            if(snew.charAt(i)=='#'){
                if(i==0){
                    snew.deleteCharAt(i);
                    i=-1;
                }
                else{
                    snew.deleteCharAt(i);
                    snew.deleteCharAt(i-1);
                    i=i-2;
                }
            }
            i++;
        }
        return snew.toString();
    }
    public boolean backspaceCompare(String s, String t) {
        String s1=isreq(s);
        String t1=isreq(t);
        return s1.equals(t1);

    }
}