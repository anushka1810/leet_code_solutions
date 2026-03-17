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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right) return head;
        ListNode dummy=new ListNode(-1);
        ListNode temp1=dummy;
        dummy.next=head;
        for(int i=0;i<left-1;i++){
            temp1=temp1.next;
        }
        ListNode temp2=temp1.next;
        ListNode l=temp2; 
        ListNode prev=temp1; 
        int index=left-1;
        while(index<right){
            ListNode next_node=l.next;
            l.next=prev;
            prev=l;
            l=next_node;
            index++;
        }
        temp2.next=l;
        temp1.next=prev;
        return dummy.next;


    }
}