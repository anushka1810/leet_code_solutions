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
    public void calculate(TreeNode root,int targetSum,ArrayList<Integer> path,List<List<Integer>> ans){
        if(root==null) return ;

        path.add(root.val);
        if(root.left==null && root.right==null){
            int sum=0;
            for(int num:path) sum+=num;

            if(sum==targetSum) ans.add(new ArrayList<>(path));
        }

        calculate(root.left,targetSum,path,ans);
        calculate(root.right,targetSum,path,ans);

        path.remove(path.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans=new ArrayList<>();

        calculate(root,targetSum,new ArrayList<>(),ans);
        return ans;
    }
}