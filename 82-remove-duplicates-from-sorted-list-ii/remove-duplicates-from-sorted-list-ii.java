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
    // public ListNode deleteDuplicates(ListNode head) {
    //     if(head==null || head.next==null) return head;
    //     ListNode temp=head.next;
    //     ListNode prev=head;
    //     ListNode dummy=new ListNode(-101,prev);
    //     ListNode prev2prev=dummy;

    //     while(temp!=null){
    //         if(prev.val!=temp.val){
    //             prev.next=temp;
    //             prev2prev=prev;
    //             prev=temp;
    //         }else{
    //             while(temp!=null && prev.val==temp.val) temp=temp.next;
    //             prev2prev.next=temp;
    //             prev=temp;
    //         }
    //         if(temp==null) break;
    //         temp=temp.next;
    //     }
    //     return dummy.next;
    // }


    
    // public ListNode deleteDuplicates(ListNode head) {
    //     if(head==null || head.next==null) return head;
    //     ListNode temp=head;
    //     ListNode dummy=new ListNode();
    //     ListNode prev=dummy;

    //     while(temp!=null){
    //         if(temp.next!=null && temp.val==temp.next.val){
    //             int val=temp.val;
    //             while(temp!=null && temp.val==val){
    //                 temp=temp.next;
    //             }
    //             prev.next=temp;
    //         }else{
    //             prev.next=temp;
    //             prev=temp;
    //             temp=temp.next;

    //         }
    //     }
    //     return dummy.next;
    // }


    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null) return head;

        ListNode dummy=new ListNode(-1);
        ListNode ansList=dummy;
        ListNode prev=head;
        ListNode temp=head;

        while(temp!=null){
            while(temp!=null && temp.val==prev.val){
                temp=temp.next;
            }
            if(prev.next==temp){
                ansList.next=prev;
                ansList=ansList.next;
                ansList.next=null;
            }

            prev=temp;

        }
        

        return dummy.next;
    }

}