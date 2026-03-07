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
    public int solve(TreeNode root,HashMap<Integer,Integer> h){
        if(root==null){
            return 0;
        }
        int sum=solve(root.left,h)+ solve(root.right,h)+root.val;
        h.put(sum,h.getOrDefault(sum,0)+1);
        return sum;
    }
    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer,Integer> h=new HashMap<>();
        solve(root,h);
        int max=Integer.MIN_VALUE;
        int count=0;
        for(int num:h.values()){
            if(num>max){
                max=num;
                count=1;
            }else if(num==max){
                count++;
            }
        }
        int ans[]=new int[count];
        int k=0;
        for(int num:h.keySet()){
            if(h.get(num)==max){
                ans[k++]=num;
            }
        }
        return ans;
    }
}