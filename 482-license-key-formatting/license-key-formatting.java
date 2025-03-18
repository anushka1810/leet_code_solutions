class Solution {
    public String licenseKeyFormatting(String s, int k) {
        s=s.toUpperCase().replace("-","");
        StringBuilder n=new StringBuilder(s);       
        n=n.reverse();


        String b=n.toString();
        int j=0;
        StringBuilder a=new StringBuilder();  

        int rep=b.length()/k;
        for(int i=0;i<rep;i++){
            for(int x=0;x<k;x++){
                a.append(b.charAt(j));
                j++;
            }
            // System.out.println(j);
            if(j!=b.length()){
                a.append("-");
            }

        }
        for(int y=j;y<b.length();y++){
            a.append(b.charAt(y));
        }
        a=a.reverse();
        String f=a.toString();
        return f;
    }
}