class Solution {
    public String reverseWords(String s) {
        String c[]=s.split(" ");
        StringBuilder snew=new StringBuilder();
        for(int i=0;i<c.length;i++){
            StringBuilder s1=new StringBuilder(c[i]);
            snew.append(s1.reverse());
            snew.append(" ");
        }
        return snew.toString().trim();
    }
}