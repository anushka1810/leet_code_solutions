class Solution {
    public int firstUniqChar(String s) {
        int uni=0;
        char ch[]=s.toCharArray();
        for(int i=0;i<ch.length;i++){
            int count=0;
            for(int j=0;j<ch.length;j++){
                if(i!=j && ch[i]==ch[j]){
                    count++;
                    break;
                }
            }
            if (count==0){
                return i;
            }
        }
        return -1;
        
    }
}