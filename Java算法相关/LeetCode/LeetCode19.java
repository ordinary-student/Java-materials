package LeetCode;

public class LeetCode19
{

	// 19. Remove Nth Node From End of List
	// https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/

	// 先记录链表总长度
	// 需要对链表进行两次遍历
	// 时间复杂度: O(n)
	// 空间复杂度: O(1)
	public ListNode removeNthFromEnd(ListNode head, int n)
	{

		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;

		int length = 0;
		for (ListNode cur = dummyHead.next; cur != null; cur = cur.next)
			length++;

		int k = length - n;
		assert k >= 0;
		ListNode cur = dummyHead;
		for (int i = 0; i < k; i++)
			cur = cur.next;

		cur.next = cur.next.next;

		return dummyHead.next;
	}

	public ListNode removeNthFromEnd2(ListNode head, int n)
	{

		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;

		ListNode p = dummyHead;
		ListNode q = dummyHead;

		// q是虚拟头结点
		for (int i = 0; i < n + 1; i++)
		{
			assert q != null;
			q = q.next;
		}

		while (q != null)
		{
			p = p.next;
			q = q.next;
		}

		p.next = p.next.next;

		return dummyHead.next;
	}

	public static void main(String[] args)
	{

		int arr[] = { 1, 2, 3, 4, 5 };
		ListNode head = new ListNode(arr);
		System.out.println(head);

		head = (new LeetCode19()).removeNthFromEnd2(head, 3);
		System.out.println(head);
	}

}
