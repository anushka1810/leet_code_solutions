
class Solution {
    public String simplifyPath(String path) {
        String arr[]=path.trim().split("/");
        Stack<String> st=new Stack<>();

        for(String s:arr){
            if(s.equals(".")|| s.equals("")) continue;
            else if(!st.isEmpty() && s.equals("..")) st.pop();
            else if(s.equals("..")) continue;
            else{
                st.push(s);
            }
        }
        StringBuilder ans=new StringBuilder();
        for(String s:st){
            ans.append("/");
            ans.append(s);
        }
        if(ans.length()==0) return "/";
        return ans.toString();
       
        
    }
}