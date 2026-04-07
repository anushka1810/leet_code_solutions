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
    public ListNode reverse(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode temp=head;
        ListNode prev=null;
        while(temp!=null){
            
            ListNode nextNode=temp.next;
            temp.next=prev;
            prev=temp;
            temp=nextNode;
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy=new ListNode(-1);

        ListNode prev=dummy;
        ListNode start=head;
        ListNode tail=head;
        ListNode curr=head;
        while(curr!=null){
            for(int i=1;i<k;i++){
                curr=curr.next;
                if(curr==null) break;
            }

            if(curr==null){
                prev.next=start;
            }else{
                tail=curr;
                curr=curr.next;
                tail.next=null;
                tail=reverse(start);
                prev.next=tail;
                prev=start;
                start=curr;
            }
        }

        return dummy.next;
    }
}