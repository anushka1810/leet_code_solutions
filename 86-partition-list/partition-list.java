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
    public ListNode partition(ListNode head, int x) {
        ListNode less=new ListNode(-1);
        ListNode great=new ListNode(-1);
        ListNode l=less;
        ListNode g=great;
        ListNode temp=head;

        while(temp!=null){
            ListNode next=temp.next;
            // temp.next=null;
            if(temp.val<x){
                l.next=temp;
                l=temp;
            }else{
                g.next=temp;
                g=temp;
            }
            temp=next;
        }
        l.next=great.next;
        g.next=null;
        return less.next;
    }
}