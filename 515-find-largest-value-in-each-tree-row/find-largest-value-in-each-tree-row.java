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
    
    // public List<Integer> largestValues(TreeNode root) {
    //     // best option is bfs
    //     List<Integer> ans=new ArrayList<>();
    //     if(root==null) return ans;
    //     Queue<TreeNode> q=new LinkedList<>();
    //     q.add(root);

    //     while(!q.isEmpty()){
    //         int size=q.size();

    //         int max=q.peek().val;
    //         for(int i=0;i<size;i++){
    //             TreeNode node=q.poll();
    //             if(node.val>max) max=node.val;
    //             if(node.left!=null) q.add(node.left);
    //             if(node.right!=null) q.add(node.right);
    //         }   
    //         ans.add(max);
    //     }
    //     return ans;
    // }

    public void dfs(TreeNode root,int height,List<Integer> ans){
        if(root==null) return;

        if(ans.size()<=height){
            ans.add(root.val);
        }else if( ans.get(height)<root.val){
            ans.set(height,root.val);
        }
        dfs(root.left,height+1,ans);
        dfs(root.right,height+1,ans);

    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        dfs(root,0,ans);
        return ans;
    }
}