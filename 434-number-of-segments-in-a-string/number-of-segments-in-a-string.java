class Solution {
    public int countSegments(String s) {
        s=s.trim();
        String[] a = s.split("\\s+");
        if(s.isEmpty()){
            return 0;
        }
        return a.length;
    }
}