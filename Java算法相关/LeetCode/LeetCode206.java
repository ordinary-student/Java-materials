package LeetCode;

public class LeetCode206
{

	// https://leetcode.com/problems/reverse-linked-list/description/
	// 时间复杂度: O(n)
	// 空间复杂度: O(1)

	// Definition for singly-linked list.
	public class ListNode
	{
		int val;
		ListNode next;

		ListNode(int x)
		{
			val = x;
		}
	}

	public ListNode reverseList(ListNode head)
	{

		ListNode pre = null;
		ListNode cur = head;
		while (cur != null)
		{
			ListNode next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}

		return pre;
	}

	// 递归方式
	public ListNode reverseList2(ListNode head)
	{

		// 递归终止条件
		if (head == null || head.next == null)
			return head;

		// head==1 --->head==2 return head ==2
		ListNode rhead = reverseList2(head.next);

		// head->next此刻指向head后面的链表的尾节点
		// head->next->next = head把head节点放在了尾部

		// TODO 最后一个节点指向倒数第二个节点
		head.next.next = head;

		// 最后一个节点指向null
		head.next = null;

		return rhead;
	}
}
