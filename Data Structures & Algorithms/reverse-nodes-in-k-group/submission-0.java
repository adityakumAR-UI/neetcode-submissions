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
    class pair{
        ListNode reversed;
        ListNode temphead;
        pair(ListNode r,ListNode t){
            this.reversed=r;
            this.temphead=t;
        }
    }
    public ListNode reverse(ListNode head){

        ListNode prev=null;
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1) return head;
        ArrayList<pair> arr=new ArrayList<>();
        ListNode temphead=head;
        int count=1;
        ListNode temp=head;
        while(temp!=null){
            if(count==k){
                ListNode agla=temp.next;
                temp.next=null;
                ListNode reversed=reverse(temphead);

                arr.add(new pair(reversed,temphead));
                temphead=agla;
                count=1;
                temp=agla;


            }
            else{
                count++;
                temp=temp.next;
            }
        }
        if(count>=1 && temphead!=null){
            arr.add(new pair(temphead,null));
        }
        ListNode res=arr.get(0).reversed;
        ListNode tempp=arr.get(0).temphead;
        
        for(int j=1;j<arr.size();j++){
            tempp.next=arr.get(j).reversed;
            tempp=arr.get(j).temphead;
            

        }
        return res;
    }
}
