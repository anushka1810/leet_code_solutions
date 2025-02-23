class Solution {
    public char findTheDifference(String s, String t) {
        char a[]=s.toCharArray();
        char b[]=t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        int n=Arrays.mismatch(a,b);
        return b[n];
    }
}