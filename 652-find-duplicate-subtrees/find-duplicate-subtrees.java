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
    List<TreeNode> ans=new ArrayList<>();
    HashMap<String,Integer> h=new HashMap<>();
    // StringBuilder s=new StringBuilder();
    public String solve(TreeNode root){
        if(root==null){
            return "#";
        }

        String a=solve(root.left);
        String b=solve(root.right);
        String temp=a+","+b+","+root.val;
        // String temp=s.toString();
        h.put(temp,h.getOrDefault(temp,0)+1);
        if(h.get(temp)==2){
            ans.add(root);
        }
        return temp;
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        solve(root);
        return ans;
    }
}