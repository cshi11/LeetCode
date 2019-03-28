package pid141;

public class Main {
	public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node3;


	    test(head);
	}

	private static void test(ListNode head) {
		Solution solution = new Solution();
		boolean output;
		long begin = System.currentTimeMillis();
		output = solution.hasCycle(head);
		long end = System.currentTimeMillis();
		System.out.println(head + ":	output=" + output);
		System.out.println();
		System.out.println("耗时：" + (end - begin) + "ms");
		System.out.println("-------------------");
	}
}