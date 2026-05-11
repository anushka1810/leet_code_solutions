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
        ListNode temp=head;
        ListNode prev=null;
        while(temp!=null){
            ListNode next=temp.next;
            temp.next=prev;
            prev=temp;
            temp=next;
        }
        return prev;
    }
    public ListNode findMiddle(ListNode head){
        ListNode fast=head;
        ListNode slow=head;


        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;

    }
    public boolean isPalindrome(ListNode head) {

        // fndmiddle 
        ListNode middle =findMiddle(head);
        ListNode head1=head;
        ListNode head2=middle.next;
        middle.next=null;
        head2=reverse(head2);

        while(head1!=null && head2!=null){
            if(head1.val!=head2.val) return false;
            head1=head1.next;
            head2=head2.next;
        }
        return true;

        
    }
}