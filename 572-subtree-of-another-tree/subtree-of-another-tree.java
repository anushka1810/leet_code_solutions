class Solution {

    public String preorder(TreeNode root){
        if(root == null) return "#";

        return "," + root.val + preorder(root.left) + preorder(root.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        String s1 = preorder(root);
        String s2 = preorder(subRoot);

        return s1.contains(s2);
    }
}