class Solution {
    public boolean solve(String s1,String s2,String s3,int i,int j,int k,Boolean dp[][]){
        if(k==s3.length()) return true;

        if(dp[i][j]!=null) return dp[i][j];

        boolean op1=false;
        if(i<s1.length() && s3.charAt(k)==s1.charAt(i)){
            op1=solve(s1,s2,s3,i+1,j,k+1,dp);
        }
        boolean op2=false;
        if(j<s2.length() && s3.charAt(k)==s2.charAt(j)){
            op2=solve(s1,s2,s3,i,j+1,k+1,dp);
        }

        dp[i][j]=op1||op2;

        return op1||op2;


    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if((s1.length()+s2.length())!=s3.length()) return false;
        Boolean dp[][]=new Boolean[s1.length()+1][s2.length()+1];
        return solve(s1,s2,s3,0,0,0,dp);
    }
}