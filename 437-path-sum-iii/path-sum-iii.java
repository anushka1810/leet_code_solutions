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
    public int solve(TreeNode root,int targetSum,HashMap<Long,Integer> h,long currSum){
        if(root==null){
            return 0;
        }
        int ans=0;
        currSum+=root.val;
        if(h.containsKey(currSum-targetSum)){
            ans+=h.get(currSum-targetSum);
        }

        h.put(currSum,h.getOrDefault(currSum,0)+1);

        ans+=solve(root.left,targetSum,h,currSum);
        ans+=solve(root.right,targetSum,h,currSum);

        h.put(currSum,h.get(currSum)-1);
        // if(h.get(currSum)==0) h.remove(currSum);

        currSum-=root.val;

        return ans;
    }
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long,Integer> h=new HashMap<>();
        h.put(0L,1);
        return solve(root,targetSum,h,0L);
    }
}