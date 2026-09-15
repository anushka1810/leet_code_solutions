class Solution {
    public String helper(int n,String prev){
        if(n==1) return prev;

        char[] arr=prev.toCharArray();
        int len=arr.length;
        int i=0;
        StringBuilder ans=new StringBuilder();
        while(i<len){
            int count=1;
            while(i+1<len && arr[i]==arr[i+1]){
                count++;
                i++;
            }
            String str=String.valueOf(count)+arr[i];
            ans.append(str);
            i++;
        }

        return helper(n-1,ans.toString());
    }
    public String countAndSay(int n) {
        StringBuilder ans=new StringBuilder("1");
        if(n==1) return ans.toString();

        return helper(n,ans.toString());
        // return ans.toString();
    }
}