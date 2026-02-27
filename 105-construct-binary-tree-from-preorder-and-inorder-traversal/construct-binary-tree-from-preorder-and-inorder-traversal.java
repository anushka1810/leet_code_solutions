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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> imap=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            imap.put(inorder[i],i);
        }
        return buildTree2(preorder,inorder,0,inorder.length-1,0,preorder.length-1,imap);
    }
    public TreeNode buildTree2(int[] preorder, int[] inorder,int istart,int iend,int pstart,int pend,HashMap<Integer,Integer> imap) {

        if(istart>iend|| pstart>pend) return null;
        TreeNode root=new TreeNode(preorder[pstart]);
        int rootkIndex=imap.get(root.val);
        int leftsize=rootkIndex-istart;

        root.left=buildTree2(preorder,inorder,istart,rootkIndex-1,pstart+1,pstart+leftsize,imap); 
        root.right=buildTree2(preorder,inorder,rootkIndex+1,iend,pstart+leftsize+1,pend,imap); 

        return root;
        
    }
}