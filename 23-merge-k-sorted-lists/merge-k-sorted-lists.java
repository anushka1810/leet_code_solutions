/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    class Pair{
        ListNode node;
        int val;
        Pair(ListNode node,int val){
            this.node=node;
            this.val=val;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->(a.val-b.val));

        for(ListNode temp:lists){
            if(temp!=null) pq.add(new Pair(temp,temp.val));
        }

        ListNode dummy=new ListNode();
        ListNode temp=dummy;

        while(!pq.isEmpty()){
            Pair p=pq.poll();
            temp.next=p.node;
            temp=temp.next;
            if(p.node.next!=null){
                pq.add(new Pair(p.node.next,p.node.next.val));
            }
        }

        return dummy.next;
        
    }
}