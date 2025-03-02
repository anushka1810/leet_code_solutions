class Solution {
    public String toGoatLatin(String sentence) {
        String arr[]=sentence.split(" ");
        StringBuilder snew=new StringBuilder();
        for(int i=0;i<arr.length;i++){
            char a=arr[i].charAt(0);
            a=Character.toLowerCase(a);
            if(a=='a'||a=='e'||a=='i'||a=='o'||a=='u'){
                snew.append(arr[i]);
            }else{
                char b[]=arr[i].toCharArray();
                for(int k=1;k<b.length;k++){
                    snew.append(b[k]);
                }
                snew.append(b[0]);
            }
            snew.append("ma");
            for(int j=0;j<i+1;j++){
                snew.append('a');
            }
            snew.append(" ");
        }
        return snew.toString().trim();
    }
}