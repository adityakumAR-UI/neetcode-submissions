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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp=l1;
        ArrayList<Integer> arr=new ArrayList<>();
        while(temp!=null){
            arr.add(temp.val);
            temp=temp.next;
            
        }
        temp=l2;
        ArrayList<Integer> a=new ArrayList<>();
        while(temp!=null){
            a.add(temp.val);
            temp=temp.next;
        }
        
        ArrayList<Integer> res=new ArrayList<>();
        int carry=0;
        int size=Math.min(arr.size(),a.size());
        for(int j=0;j<size;j++){
            int t=arr.get(j)+a.get(j)+carry;
            if(t>=10) {
                t=t%10;
                carry=1;
            }
            else carry=0;
            res.add(t);
        }
        while(arr.size()>size){
            int f=arr.get(size)+carry;
            if(f>=10) {
                f=f%10;
                carry=1;
            }
            else carry=0;
            res.add(f);
            size++;

        }
        while(a.size()>size){
            int f=a.get(size)+carry;
            if(f>=10) {
                f=f%10;
                carry=1;
            }
            else carry=0;
            res.add(f);
            size++;

        }
        if(carry>0) res.add(carry);
        ListNode head=new ListNode(res.get(0));
        temp=head;
        for(int i=1;i<res.size();i++){
            ListNode j=new ListNode(res.get(i));
            temp.next=j;
            temp=temp.next;
        }
        return head;

        

        
    }
}
