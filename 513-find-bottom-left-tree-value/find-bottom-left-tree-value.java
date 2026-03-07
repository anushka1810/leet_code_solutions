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
    // public int solve(TreeNode root){
    //     Queue<TreeNode> q=new LinkedList<>();
    //     q.add(root);
    //     int ans=root.val;

    //     while(!q.isEmpty()){
    //         int size=q.size();

    //         for(int i=0;i<size;i++){
    //             TreeNode node=q.poll();
    //             if(i==0) ans=node.val;
    //             if(node.left!=null) q.add(node.left);
    //             if(node.right!=null) q.add(node.right);
    //         }   
    //     }
    //     return ans;
    // }
    // public int findBottomLeftValue(TreeNode root) {
    //     if(root==null) return 0;
    //     return solve(root);
    // }
    int ans=-1;
    int maxheight=-1;
    public void dfs(TreeNode root,int height){
        if(root==null) return;
        if(height>maxheight){
            maxheight=height;
            ans=root.val;
        }
        dfs(root.left,height+1);
        dfs(root.right,height+1);
    }
    public int findBottomLeftValue(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null && root.right==null) return root.val;
        dfs(root,0);
        return ans;
    }
}