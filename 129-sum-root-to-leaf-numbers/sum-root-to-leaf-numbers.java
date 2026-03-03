/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // int ans=0;
    // public void solve(TreeNode root,StringBuilder val){
        
    //     val.append(root.val);
    //     int size=val.length();
    //     if(root.left==null && root.right==null){
    //         int a=Integer.valueOf(val.toString());
    //         ans+=(a);
    //     }else{
    //         if(root.left!=null) solve(root.left,val);
    //         if(root.right!=null) solve(root.right,val);
    //     }
    //     val.deleteCharAt(size-1);

        
    // }
    // public int sumNumbers(TreeNode root) {
    //      if(root==null) return 0;
    //      solve(root,new StringBuilder());
    //      return ans;
    // }


    int ans=0;
    public void solve(TreeNode root,int val){
        int prev=val;
        val=(val*10)+root.val;
        if(root.left==null && root.right==null){
            ans+=val;
        }else{
            if(root.left!=null) solve(root.left,val);
            if(root.right!=null) solve(root.right,val);
        }
        val=prev;  
    }
    public int sumNumbers(TreeNode root) {
         if(root==null) return 0;
         solve(root,0);
         return ans;
    }
}