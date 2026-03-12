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
    // public TreeNode solve(int[] inorder,int is,int ie,int[] preorder,int ps,int pe,HashMap<Integer,Integer> imap){
    //     if(is>ie || ps>pe) return null;

    //     int val=preorder[ps];
    //     TreeNode root=new TreeNode(val);
    //     int index=imap.get(val);
    //     int no=index-is;
    //     root.left=solve(inorder,is,index-1,preorder,ps+1,ps+(index-is),imap);
    //     root.right=solve(inorder,index+1,ie,preorder,ps+(index-is)+1,pe,imap);

    //     return root;
    // }
    // public TreeNode bstFromPreorder(int[] preorder) {
    //     int[] inorder=Arrays.copyOf(preorder,preorder.length);
    //     HashMap<Integer,Integer> imap=new HashMap<>();
    //     Arrays.sort(inorder);
    //     for(int i=0;i<inorder.length;i++){
    //         imap.put(inorder[i],i);
    //     }


    //     return solve(inorder,0,inorder.length-1,preorder,0,inorder.length-1,imap);
     // }


    int i=0;
     public TreeNode solve(int[] preorder,int up){
        if(i==preorder.length || preorder[i]>up) return null;

        TreeNode root=new TreeNode(preorder[i++]);
        root.left=solve(preorder,root.val);
        root.right=solve(preorder,up);

        return root;
     }
     public TreeNode bstFromPreorder(int[] preorder) {

        return solve(preorder,Integer.MAX_VALUE);
     }
}