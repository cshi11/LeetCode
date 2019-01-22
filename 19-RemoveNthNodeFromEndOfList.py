'''
@Description: In User Settings Edit
@Author: your name
@Date: 2019-01-22 12:40:41
@LastEditTime: 2019-01-22 13:13:45
@LastEditors: Please set LastEditors
            remove the n-th node from the end of list and return its head.
            Example:
            Given linked list: 1->2->3->4->5, and n = 2.
            After removing the second node from the end, 
            the linked list becomes 1->2->3->5.
@Note: 用两个间隔为 n 的指针实现 O(n) 复杂度
'''
# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """
        # 增加头节点，好处理
        headNode = ListNode(0)
        headNode.next = head
        p = q = headNode
        # 一次性变量 用 _
        for _ in range(n):
            p = p.next
        while p.next:
            p = p.next
            q = q.next
        q.next = q.next.next
        return headNode.next

head = ListNode(1)
node = head
for i in range(2,6):
    node.next = ListNode(i)
    node = node.next

solution = Solution()
ret = solution.removeNthFromEnd(head, 2)

p = ret
while p:
    print(p.val)
    p = p.next