class Solution {
    public String convert(String s, int numRows) {
        int len=s.length();
        if (numRows == 1 || numRows >= len) {
            return s;
        }
        ArrayList<StringBuilder> list=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            list.add(new StringBuilder());
        }
        list.get(0).append(s.charAt(0));
        int k=1;

        while(k<len){
            int j=1;
            while(k<len && j<numRows){
                list.get(j).append(s.charAt(k));
                j++;
                k++;
            }
            j=numRows-2;
            while(k<len && j>=0){
                list.get(j).append(s.charAt(k));
                j--;
                k++;
            }
        }

        StringBuilder ans=new StringBuilder();

        for(StringBuilder st:list){
            ans.append(st.toString());
        }
        return ans.toString();

    }
}