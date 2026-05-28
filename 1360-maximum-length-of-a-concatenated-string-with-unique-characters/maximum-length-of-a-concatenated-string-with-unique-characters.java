class Solution {
    public boolean isValid(List<String> arr,HashSet<Character> h,int idx){
        HashSet<Character> temp=new HashSet<>();
        for(char ch:arr.get(idx).toCharArray()){
            if(temp.contains(ch)) return false;
            if(h.contains(ch)) return false;
            temp.add(ch);
        }
        return true;
    }
    public int solve(List<String> arr,HashSet<Character> h,int idx,StringBuilder str,int ansKiLength){
        if(idx==arr.size()){
            int len=str.length();
            return Math.max(len,ansKiLength);
        }

        if(isValid(arr,h,idx)){
            int oldlen=str.length();
            for(char ch:arr.get(idx).toCharArray()){
                h.add(ch);
            }
            str.append(arr.get(idx));

            ansKiLength=solve(arr,h,idx+1,str,ansKiLength);
            
            for(char ch:arr.get(idx).toCharArray()){
                h.remove(ch);
            }
            str.delete(oldlen,str.length());
        }
        ansKiLength=solve(arr,h,idx+1,str,ansKiLength);
        return ansKiLength;
    }
    public int maxLength(List<String> arr) {
        HashSet<Character> h=new HashSet<>();
        StringBuilder s=new StringBuilder();

        return solve(arr,h,0,s,0);
    }
}