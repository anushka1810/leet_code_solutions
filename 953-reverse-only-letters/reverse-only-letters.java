class Solution {
    public String reverseOnlyLetters(String s) {
        char[] a=s.toCharArray();
        StringBuilder s1=new StringBuilder();
        for(int i=0;i<a.length;i++){
            if(Character.isLetter(a[i])){
                s1.append(a[i]);
            }
        }
        System.out.println(s1);
        s1.reverse();
        System.out.println(s1);
        for(int i=0;i<a.length;i++){
            if(!Character.isLetter(a[i])){
                s1.insert(i,a[i]);
            }
        }
        return s1.toString();
    }
}