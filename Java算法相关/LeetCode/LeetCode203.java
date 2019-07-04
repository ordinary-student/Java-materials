package LeetCode;

public class LeetCode203
{

	// https://leetcode.com/problems/remove-linked-list-elements/description/
	// 不使用虚拟头结点
	// 时间复杂度: O(n)
	// 空间复杂度: O(1)

	public ListNode removeElements(ListNode head, int val)
	{

		// 需要对头结点进行特殊处理
		while (head != null && head.val == val)
		{
			ListNode node = head;
			head = head.next;
		}

		if (head == null)
			return head;

		ListNode cur = head;
		while (cur.next != null)
		{
			if (cur.next.val == val)
			{
				ListNode delNode = cur.next;
				cur.next = delNode.next;
			} else
				cur = cur.next;
		}
		return head;
	}

	// 弄了一个虚拟节点(不用对头结点再做处理了)
	public ListNode removeElements2(ListNode head, int val)
	{

		// 创建虚拟头结点
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;

		ListNode cur = dummyHead;
		while (cur.next != null)
		{
			if (cur.next.val == val)
			{
				ListNode delNode = cur.next;
				cur.next = delNode.next;
			} else
				cur = cur.next;
		}

		return dummyHead.next;
	}

	// 递归的方式来做
	public ListNode removeElements3(ListNode head, int val)
	{

		if (head == null)
			return head;

		// 用下一个节点跟value比较
		ListNode res = removeElements3(head.next, val);

		if (head.val == val)
			return res;
		else
		{
			head.next = res;
			return head;
		}
	}

	// 递归的方式来做--->其实就是一个子串删除的问题。
	public ListNode removeElements4(ListNode head, int val)
	{

		if (head == null)
			return head;

		// 删除重复的节点，拿到子串
		head.next = removeElements4(head.next, val);

		// 如果头节点是要删除的节点，返回子串。如果不是，返回当前子串
		return head.val == val ? head.next : head;
	}

	public static void main(String[] args)
	{

		int[] nums = { 1, 2, 6, 3, 4, 5, 6 };
		ListNode head = new ListNode(nums);
		System.out.println(head);

		ListNode res = (new LeetCode203()).removeElements3(head, 6);
		System.out.println(res);
	}
}
