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
    List<Integer> ans = new ArrayList<>();
    int max = Integer.MIN_VALUE;
    int count = 0;

    public int solve(TreeNode root, HashMap<Integer, Integer> h) {
        if (root == null) {
            return 0;
        }
        int sum = solve(root.left, h) + solve(root.right, h) + root.val;
        h.put(sum, h.getOrDefault(sum, 0) + 1);
        if (h.get(sum) > max) {
            ans.clear();
            ans.add(sum);
            max = h.get(sum);
            count = 1;
        } else if (h.get(sum) == max) {
            ans.add(sum);
        }
        return sum;
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer, Integer> h = new HashMap<>();
        solve(root, h);
        // int ans[]=new int[count];
        // int k=0;
        // for(int num:h.keySet()){
        //     if(h.get(num)==max){
        //         ans[k++]=num;
        //     }
        // }
        // return ans;
        int[] res = new int[ans.size()];

        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}