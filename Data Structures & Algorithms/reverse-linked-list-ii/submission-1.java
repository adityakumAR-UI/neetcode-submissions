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

    public ListNode reverse(ListNode head, int c) {
        int temp = 1;
        ListNode prev = null;
        ListNode curr = head;
        ListNode agla = null;

        while (curr != null && temp <= c) {
            agla = curr.next;
            curr.next = prev;
            prev = curr;
            curr = agla;
            temp++;
        }

        head.next = curr;
        return prev;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || left == right)
            return head;

        ListNode temp = head;
        int c = 1;

        while (temp != null) {

            if (left == 1) {
                return reverse(head, right - left + 1);
            }

            if (c == left - 1) {
                temp.next = reverse(temp.next, right - left + 1);
                return head;
            }

            temp = temp.next;
            c++;
        }

        return head;
    }
}