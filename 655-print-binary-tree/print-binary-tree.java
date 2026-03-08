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
    public void solve(TreeNode root,String[][] res,int r,int c,int h){
        if(root==null) return;

        if(root.left!=null){
            int c1=c-(int)Math.pow(2,h-r-2);
            res[r+1][c1]=String.valueOf(root.left.val);
            solve(root.left,res,r+1,c1,h);
        }
        if(root.right!=null){
            int c1=c+(int)Math.pow(2,h-r-2);
            res[r+1][c1]=String.valueOf(root.right.val);
            solve(root.right,res,r+1,c1,h);
        }

    }
    public int maxHeight(TreeNode root){
        if(root==null) return 0;

        int l=maxHeight(root.left);
        int r=maxHeight(root.right);

        return Math.max(l,r)+1;
    }
    public List<List<String>> printTree(TreeNode root) {
        int h=maxHeight(root);
        int n=(int)Math.pow(2,h)-1;

        String[][] res=new String[h][n];
        for(int i=0;i<h;i++){
            Arrays.fill(res[i],"");
        }

        res[0][(n-1)/2]=String.valueOf(root.val);
        solve(root,res,0,(n-1)/2,h);

        List<List<String>> ans = new ArrayList<>();

        for(String[] row : res){
            ans.add(Arrays.asList(row));
        }

        return ans;



        
    }
}