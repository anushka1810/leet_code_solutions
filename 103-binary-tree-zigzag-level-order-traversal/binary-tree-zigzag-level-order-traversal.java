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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;
        boolean isrev=false;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> level=new ArrayList<>();
            int[] arr=new int[size];

            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                if(isrev){
                    arr[size-i-1]=node.val;
                }else{
                    arr[i]=node.val;
                }

                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            isrev=!isrev;

            for(int num:arr){
                level.add(num);
            }
            ans.add(level);
            
        }
        return ans;

    }
}