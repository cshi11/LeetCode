package pid23;

public class Main{
    public static void main(String[] args) {
        ListNode node2 = new ListNode(-1);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(11);

        ListNode node6 = new ListNode(6);
        ListNode node10 = new ListNode(10);


        /*ListNode node1 = new ListNode(2);
        ListNode node5 = new ListNode(3);
        ListNode node7 = new ListNode(7);
        ListNode node26 = new ListNode(26);
        ListNode node111 = new ListNode(111);
        ListNode node11 = new ListNode(1);
        ListNode node9 = new ListNode(9);
        ListNode node10 = new ListNode(10);
        ListNode node12 = new ListNode(12);
        ListNode node119 = new ListNode(119);
        */

        node2.next = node3;
        node3.next = node4;

        node6.next = node10;

        /*node1.next = node5;
        node5.next = node7;
        node7.next = node26;
        node26.next = node111;
        node11.next = node9;
        node9.next = node10;
        node10.next = node12;
        node12.next = node119;*/
        ListNode[] list = new ListNode[4];
        list[0] = null;
        list[1] = node2;
        list[2] = null;
        list[3] = node6;
        ListNode result = new Solution().mergeKLists(list);

        String res = "";
        for (ListNode p = result; p!=null; p = p.next){
            res += p.val + " -> ";
        }
        System.out.println(res);

    }
}

