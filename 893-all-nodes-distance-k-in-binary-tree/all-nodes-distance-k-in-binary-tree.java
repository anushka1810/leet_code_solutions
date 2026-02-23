/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    class Pair{
        TreeNode root;
        int dist;
        Pair(TreeNode root,int dist){
            this.root=root;
            this.dist=dist;
        }
    }
    public void Parent(TreeNode curr,TreeNode p,HashMap<TreeNode,TreeNode> parent){
        if(curr==null) return;
        parent.put(curr,p);
        Parent(curr.left,curr,parent);
        Parent(curr.right,curr,parent);
    }
    // public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    //     HashMap<TreeNode,TreeNode> parent=new HashMap<>();
    //     Parent(root,null,parent);
    //     Queue<TreeNode> q=new  LinkedList<>();
    //     // boolean visited[]=new boolean[501];
    //     Set<TreeNode> visited = new HashSet<>();

    //     q.add(target);
    //     // visited[target.val]=true;
    //     visited.add(target);
    //     int count=0;

    //     while(!q.isEmpty() && count<k){
    //         int size=q.size();

    //         for(int i=0;i<size;i++){
    //             TreeNode node=q.poll();
    //             if(node.left!=null && !visited.contains(node.left)){
    //                 q.add(node.left);
    //                 // visited[node.left.val]=true;
    //                 visited.add(node.left);
    //             }
    //             if(node.right!=null && !visited.contains(node.right)){
    //                 q.add(node.right);
    //                 // visited[node.right.val]=true;
    //                 visited.add(node.right);
    //             }
    //             if(parent.get(node)!=null && !visited.contains(parent.get(node))){
    //                 q.add(parent.get(node));
    //                 // visited[parent.get(node).val]=true;
    //                 visited.add(parent.get(node));
    //             }  
    //         }
    //         count++; 
    //     }

    //     List<Integer> ans=new ArrayList<>();
    //     for(TreeNode r:q){
    //         ans.add(r.val);
    //     }
    //     return ans;
    // }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,TreeNode> parent=new HashMap<>();
        Parent(root,null,parent);
        Queue<Pair> q=new  LinkedList<>();
        // boolean visited[]=new boolean[501];
        Set<TreeNode> visited = new HashSet<>();
        List<Integer> ans=new ArrayList<>();

        q.add(new Pair(target,0));
        visited.add(target);


        while(!q.isEmpty()){
            Pair detail=q.poll();

            TreeNode node=detail.root;
            int distance=detail.dist;

            if(distance==k){
                ans.add(node.val);
            }else if(distance<k){
                TreeNode p=parent.get(node);
                TreeNode l=node.left;
                TreeNode r=node.right;

                if(p!=null && !visited.contains(p)){
                    q.add(new Pair(p,distance+1));
                    visited.add(p);
                }
                if(l!=null && !visited.contains(l)){
                    q.add(new Pair(l,distance+1));
                    visited.add(l);
                }
                if(r!=null && !visited.contains(r)){
                    q.add(new Pair(r,distance+1));
                    visited.add(r);
                }
            }

        }

        return ans;

        
    }
}