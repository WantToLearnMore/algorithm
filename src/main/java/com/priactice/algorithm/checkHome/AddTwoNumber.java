package com.priactice.algorithm.checkHome;


public class AddTwoNumber {
    public ListNode solution(ListNode l1,ListNode l2){
        int carry=0;
        int sum=l1.val+l2.val;
        if(sum/10!=0){
            carry=1;
        }

        ListNode head=new ListNode(sum%10);
        ListNode p=l1.next;
        ListNode q=l2.next;
        ListNode current=head;

        while (p!=null||q!=null||carry>0){
            int m=0;
            int n=0;
            if(p!=null){
                m=p.val;
                p=p.next;
            }
            if(q!=null){
                n=q.val;
                q=q.next;
            }
            sum=m+n+carry;
            ListNode node=new ListNode(sum%10);
            current.next=node;
            current=node;
            if(sum/10!=0){
                carry=1;
            }else {
                carry=0;
            }
        }
        return head;
    }




    public ListNode solution2(ListNode l1,ListNode l2){
        ListNode p = l1;
        ListNode q = l2;
        int addNum = 0;
        while(q!=null){
            if(p.next==null && q.next!=null)
                p.next = new ListNode(0);
            if(q.next==null && p.next!=null)
                q.next = new ListNode(0);
            int sumAll = addNum + p.val + q.val;
            p.val = sumAll % 10;
            addNum = sumAll / 10;
            if(p.next == null && q.next == null && addNum!=0)
                p.next = new ListNode(addNum);
            p = p.next;
            q = q.next;
        }
        return l1;
    }


    public static void main(String []args){
        int s=7%3;
        System.out.println(s);


    }
}
class ListNode{
      int val;
      ListNode next;
    public ListNode(int x){val=x;}

    public ListNode getNext(){
        return this.next;
    }

    public void setNext(ListNode next){
        this.next=next;
    }

    public int getVal(){
        return this.val;
    }

    public void setVal(int val){
        this.val=val;
    }
}