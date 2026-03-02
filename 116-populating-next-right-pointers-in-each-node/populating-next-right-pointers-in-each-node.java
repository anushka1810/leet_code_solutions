/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public void solve(Node root,HashMap<Node,Node> parent){
        if(root==null) return;

        Node paa=parent.get(root);

        if(paa.left==root){
            root.next=paa.right;
        }else{
            if(paa.next!=null){
                root.next=paa.next.left;
            }
        }
        solve(root.left,parent);
        solve(root.right,parent);


    }
    public Node connect(Node root) {
        if(root==null) return null;
        if(root.left==null) return root;
        HashMap<Node,Node> parent=new HashMap<>();
        parent.put(root,null);
        Queue<Node> q=new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            Node node=q.poll();
            if(node.left!=null){
                q.add(node.left);
                parent.put(node.left,node);
            }
            if(node.right!=null){
                q.add(node.right);
                parent.put(node.right,node);
            }
        }

        solve(root.left,parent);
        solve(root.right,parent);
        return root;
    }
}