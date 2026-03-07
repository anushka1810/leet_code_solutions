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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode new_node=new TreeNode(val);
            new_node.left=root;
            return new_node;
        }

        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int d=1;
        while(!q.isEmpty()){
            int size=q.size();
            if(d==depth-1){
                for(int i=0;i<size;i++){
                    TreeNode node=q.poll();
                    TreeNode leftchild=node.left;
                    TreeNode rightchild=node.right;
                    TreeNode new_nodel=new TreeNode(val);
                    TreeNode new_noder=new TreeNode(val);
                    node.left=new_nodel;
                    node.right=new_noder;
                    new_nodel.left=leftchild;
                    new_noder.right=rightchild;
                }
            }else{
                for(int i=0;i<size;i++){
                    TreeNode node=q.poll();
                    if(node.left!=null) q.add(node.left);
                    if(node.right!=null) q.add(node.right);
                }
            }
            d++;
        }
        return root;
    }
}