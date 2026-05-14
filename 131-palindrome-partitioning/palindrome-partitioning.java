class Solution {
    public boolean isPalindrome(String s){
        int n=s.length();
        if(n==0|| n==1) return true;

        for(int i=0;i<n/2;i++){
            if(s.charAt(i)!=s.charAt(n-i-1)) return false;
        }
        return true;

    }
    public void helper(String s,int idx, List<List<String>> ans,List<String> path){
        if(idx==s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int i=idx;i<s.length();i++){
            String str=s.substring(idx,i+1);
            if(isPalindrome(str)){
                path.add(str);
                helper(s,i+1,ans,path);
                path.remove(path.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        List<String> path=new ArrayList<>();

        helper(s,0,ans,path);
        return ans;

    }
}