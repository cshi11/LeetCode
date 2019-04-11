package pid24;
/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * Example:
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 */

class SwapNodes{

    public static ListNode swapPairs(ListNode head) {

        if((head == null)|| (head.next == null)){
            return head;
        }
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = null;

        ListNode p = swapPairs(a);
        String result = "";
        while(p != null){
            result += " " + p.val + "->";
            p = p.next;
        }
        System.out.println(result);
    }

    private static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val = x;}
    }
}