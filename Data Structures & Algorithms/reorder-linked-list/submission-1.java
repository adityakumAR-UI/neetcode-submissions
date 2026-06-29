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
        ListNode  prev=null;
        ListNode curr=head;
        ListNode agla=null;
        while(curr!=null){
            agla=curr.next;
            curr.next=prev;
            prev=curr;
            curr=agla;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode reversed=reverse(slow.next);
        slow.next = null; 
        ListNode temp=head;
        
        while(temp!=slow){
            ListNode a=temp.next;
            temp.next=reversed;
            reversed=reversed.next;
            temp.next.next=a;
            temp=a;
            
        }if(reversed!=null) temp.next=reversed;
        return ;
    }
}
