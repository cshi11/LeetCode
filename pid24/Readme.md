# 24. Swap Nodes in Pairs

## 思路
- 典型递归题目
    - 大问题可以分解为小问题
    -  每个小问题有相同的解法
    -  整个链表交换分解为前两个元素的交换和剩余链表的交换，而剩余链表的交换也可这样分下去

- 递推公式
  - `SwapNodes(head) = swap(head, head.next) + SwapNodes(head.next.next);`

- 终止条件： `head == null || head.next == null`
   