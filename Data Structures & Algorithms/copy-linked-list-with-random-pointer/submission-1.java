/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        //  fill in between 
        Node temp=head;
        while(temp!=null){
            Node newnode=new Node (temp.val);
            Node agla=temp.next;
            temp.next=newnode;
            newnode.next=agla;
            temp=agla;

        }

        //  connect random pointer
        temp=head;

        while(temp!=null){
            Node rand=temp.random;
           if(rand!=null) temp.next.random=rand.next;
           else temp.next.random=null;
           temp=temp.next.next;

            
        }
        // connect next pointer

        Node dummynode =new Node(-1);
        Node res=dummynode;
        temp=head;
        while(temp!=null){
            Node copy=temp.next;
            temp.next=temp.next.next;
            copy.next=null;
            res.next=copy;
            res=copy;
            temp=temp.next;
        }
        return dummynode.next;
        
    }
}
