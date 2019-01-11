/**
 *  You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *  You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *  Example:
 *  Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *  Output: 7 -> 0 -> 8
 *  Explanation: 342 + 465 = 807.
 *  Definition for singly-linked list.
 *  function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function(l1, l2) {
    var i,j = 0
    var p = l1, q = l2
    var l3 = new ListNode()
    var k = l3
    while(p || q){
        var pval = (p)? p.val : 0
        var qval = (q)? q.val : 0
        i = (pval + qval + j)%10
        // js 地板除的写法
        j = parseInt((pval + qval + j)/10)
        if(p){ p = p.next }
        if(q){ q = q.next }
        if(p || q){
            k.next = new ListNode()
            k = k.next
        }
        else if(j){
            k.next = new ListNode()
            k = k.next
            k.val = j
        }
    }
    return l3
};

