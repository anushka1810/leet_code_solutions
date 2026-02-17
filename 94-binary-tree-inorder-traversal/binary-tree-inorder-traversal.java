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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        Stack<TreeNode> st=new Stack<>();
        if(root==null) return ans;
        st.push(root);

        while(!st.isEmpty()){
            TreeNode node=st.peek();
            if(node==null){
                st.pop();
                TreeNode next1=st.pop();
                ans.add(next1.val);
                if(next1.right!=null || st.size()>0) st.add(next1.right); 
            // }
            // if(st.peek().left==null){
            //     ans.add(st.pop().val);
            //     if()
            }else{
                st.push(node.left);
            }


        }
        return ans;
    }
}