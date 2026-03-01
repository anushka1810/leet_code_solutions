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
    public boolean isLeaf(TreeNode root){
        if(root.left==null && root.right==null) return true;
        return false;
    }
    public void solve(TreeNode node,List<List<Integer>> ans,List<Integer> path,int sum,int target){
        path.add(node.val);
        int size=path.size();
        sum+=node.val;
        if(isLeaf(node)){
            if(sum==target){
                ans.add(new ArrayList<>(path));
            }
        }else{
            if(node.left!=null) solve(node.left,ans,path,sum,target);
            if(node.right!=null) solve(node.right,ans,path,sum,target);
        }
        path.remove(size-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        if(root==null) return ans;
        solve(root,ans,path,0,targetSum);
        return ans;
    }
}