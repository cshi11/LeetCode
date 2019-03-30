package pid23;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution{
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)  return null;
        return helper(lists, 0 ,lists.length -1);
    }

    private ListNode helper(ListNode[] lists, int left, int right){
        if(left >= right)    return lists[left];
        int mid = (left + right)/2;
        ListNode l0 = helper(lists, left, mid);
        ListNode l1 = helper(lists, mid + 1, right);
        return merge2lists(l0, l1);
    }

    private ListNode merge2lists(ListNode l0, ListNode l1){
        ListNode head = new ListNode(0), temp = head;
        while(l0 != null && l1 != null){
            if(l0.val < l1.val){
                temp.next = new ListNode(l0.val);
                l0 = l0.next;
            }else{
                temp.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            temp = temp.next;
        }
        temp.next = l0 != null ?l0 : l1;
        return head.next;
    }
}