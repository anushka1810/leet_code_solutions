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



// brute force
// class Solution {
//     public int size(ListNode head){
//         ListNode temp=head;
//         int count=0;
//         while(temp!=null){
//             count++;
//             temp=temp.next;
//         }
//         return count;
//     }
//     public ListNode rotateRight(ListNode head, int k) {
//         // size of linked list 
//         if(head==null ||head.next==null) return head;
//         int size=size(head);
//         k=k%size;
//         if(k==0) return head;

//         while(k>0){
//             ListNode temp1=head;
//             while(temp1.next.next!=null){
//                 temp1=temp1.next;
//             }
//             ListNode rotateNode=temp1.next;
//             temp1.next=null;
//             rotateNode.next=head;
//             head=rotateNode;
//             k--;
//         }
//         return head;

//     }
// }


// optimal
// class Solution {
//     public ListNode rotateRight(ListNode head, int k) {
//         if(head==null ||head.next==null) return head;
//         ListNode temp=head;
//         ListNode tail=null;
//         int count=0;
//         while(temp!=null){
//             count++;
//             tail=temp;
//             temp=temp.next;
//         }
//         k=k%count;
//         if(k==0) return head;
//         tail.next=head;
//         ListNode temp2=head;
//         for(int i=0;i<count-k-1;i++){
//             temp2=temp2.next;
//         }
//         head=temp2.next;
//         temp2.next=null;
//         return head;
//     }
// }



class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k==0) return head;
        ListNode slow=head;
        ListNode fast=head;
        ListNode temp=head;
        int n=0;
        while(temp!=null){
            temp=temp.next;
            n++;
        }
        k=k%n;

        for(int i=0;i<k;i++){
            fast=fast.next;
        }

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }

        fast.next=head;
        head=slow.next;
        slow.next=null;

        return head;
    }
}