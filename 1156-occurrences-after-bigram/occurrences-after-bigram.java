class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        String[] s1=text.split(" ");
        StringBuilder sec=new StringBuilder();
        System.out.println(sec);
        for(int i=0;i<s1.length-2;i++){
            if(s1[i].equals(first) && s1[i+1].equals(second)){
                sec.append(s1[i+2]);
                sec.append(" ");
            }
        }
        String f=sec.toString();
        String[] ok=f.split(" ");
        if(f.isEmpty()){
            // String arr[]=new String();
            return new String[0];
        }
        return ok;
    }
}