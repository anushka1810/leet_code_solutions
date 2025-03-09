class Solution {
    public String truncateSentence(String s, int k) {
        String s1[]=s.split(" ");
        StringBuilder snew=new StringBuilder();
        for(int i=0;i<k;i++){
            snew.append(s1[i]);
            snew.append(" ");
        }
        return snew.toString().trim();
    }
}