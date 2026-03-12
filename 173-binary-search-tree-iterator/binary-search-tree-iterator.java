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
class BSTIterator {
    TreeNode root;
    Stack<TreeNode> st=new Stack<>();

    public BSTIterator(TreeNode root) {
        this.root=root;
        insert(root);
    }
    public void insert(TreeNode node){
        TreeNode temp=node;
        while(temp!=null){
            st.push(temp);
            temp=temp.left;
        }
    }
    
    public int next() {
        TreeNode node=st.pop();
        insert(node.right);

        return node.val;

    }
    
    public boolean hasNext() {
        return (!st.isEmpty());
        
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */