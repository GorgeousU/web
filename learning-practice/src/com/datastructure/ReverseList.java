package com.datastructure;

/**
 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 例：
 输入：head = [1,2,3,4,5]
 输出：[5,4,3,2,1]
*/
public class ReverseList {
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /**
     * 创建内容为1 2 3 4 5的链表，使用reverseList方法反转链表，并利用printList方法打印
     */
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);

        ListNode res = reverseList(node1);
        printList(res);
    }

    // 打印链表的方法
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }
}
