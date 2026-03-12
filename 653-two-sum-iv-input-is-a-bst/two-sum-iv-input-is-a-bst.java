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
    public boolean solve(TreeNode root,HashSet<Integer> h,int k){
        if(root==null) return false;

        int target=k-root.val;
        if(h.contains(target)) return true;
        
        h.add(root.val);
        return solve(root.left,h,k)||solve(root.right,h,k);
    }
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> h=new HashSet<>();

        return solve(root,h,k);
    }
}