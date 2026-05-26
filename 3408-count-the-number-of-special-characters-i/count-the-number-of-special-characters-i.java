class Solution {
    public int numberOfSpecialChars(String word) {
        int[] lowercase=new int[26];
        int[] uppercase=new int[26];

        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);

            if(ch>=65 && ch<=90){
                uppercase[ch-'A']++;
            }else if(ch>=97 && ch<=122){
                lowercase[ch-'a']++;
            }
        }

        int count=0;
        for(int i=0;i<26;i++){
            if(lowercase[i]!=0 && uppercase[i]!=0) count++;
        }
        return count;
        
    }
}