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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> imap=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            imap.put(inorder[i],i);
        }
        return buildTree2(postorder,inorder,0,inorder.length-1,0,postorder.length-1,imap);
    }
    public TreeNode buildTree2(int[] postorder, int[] inorder,int istart,int iend,int pstart,int pend,HashMap<Integer,Integer> imap) {

        if(istart>iend|| pstart>pend) return null;
        TreeNode root=new TreeNode(postorder[pend]);
        int rootkIndex=imap.get(root.val);
        int leftsize=rootkIndex-istart;

        root.left=buildTree2(postorder,inorder,istart,rootkIndex-1,pstart,pstart+leftsize-1,imap); 
        root.right=buildTree2(postorder,inorder,rootkIndex+1,iend,pstart+leftsize,pend-1,imap); 

        return root;
        
    }
}