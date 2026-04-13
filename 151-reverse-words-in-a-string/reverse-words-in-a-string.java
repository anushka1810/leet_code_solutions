class Solution {
    public String reverseWords(String s) {
        String[] s1 = s.trim().split("\\s+");
        int n = s1.length;
        for (int i = 0; i < s1.length/2; i++) {
            String temp = s1[i];
            s1[i] = s1[n-i-1];
            s1[n-i-1] = temp;
        }
        StringBuilder ans = new StringBuilder();
        for (String s2 : s1) {
            ans.append(s2 + " ");
        }

        return ans.toString().trim();

    }
}