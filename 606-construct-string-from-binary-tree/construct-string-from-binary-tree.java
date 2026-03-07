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
    StringBuilder ans=new StringBuilder();
    public void solve(TreeNode root){
        if(root==null) return;
        ans.append("(");
        ans.append(root.val);
        if(root.left!=null || root.right!=null){
            if(root.left==null){
                ans.append("()");
            }else{
                solve(root.left);
            }
        }
        solve(root.right);
        ans.append(")");
    }
    public String tree2str(TreeNode root) {
        solve(root);
        ans.deleteCharAt(0);
        ans.deleteCharAt(ans.length()-1);
        return ans.toString();
    }
}