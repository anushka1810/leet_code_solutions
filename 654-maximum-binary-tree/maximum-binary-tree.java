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
    public int max(int[] nums,int start,int end){
        int max=start;
        for(int i=start;i<=end;i++){
            if(nums[i]>nums[max]){
                max=i;
            }
        }
        return max;
    }
    public TreeNode solve(int[] nums,int start,int end){
        if(start>end) return null;

        int maxKIndex=max(nums,start,end);
        TreeNode new_node=new TreeNode(nums[maxKIndex]);

        new_node.left=solve(nums,start,maxKIndex-1);
        new_node.right=solve(nums,maxKIndex+1,end);
        return new_node;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return solve(nums,0,nums.length-1);
    }
}