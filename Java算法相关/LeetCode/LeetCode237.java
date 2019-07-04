package LeetCode;

public class LeetCode237
{

	// 237. Delete Node in a Linked List
	// https://leetcode.com/problems/delete-node-in-a-linked-list/description/
	// 时间复杂度: O(1)
	// 空间复杂度: O(1)

	// 这里只给出链表的值让我们删除--->一般我们删除链表的节点需要找到对应的前一个节点
	// 由于这里仅仅是值，所以我们可以这样做：
	// 1. 找到给定值的节点
	// 2. 将找到的节点的下一个节点的值赋值给当前节点
	// 3. 删除掉下一个节点
	public void deleteNode(ListNode node)
	{

		// 注意: 这个方法对尾节点不适用。题目中要求了给定的node不是尾节点
		// 我们检查node.next, 如果为null则抛出异常, 确保了node不是尾节点
		if (node == null || node.next == null)
			throw new IllegalArgumentException("node should be valid and can not be the tail node.");

		node.val = node.next.val;
		node.next = node.next.next;
	}

	public static void main(String[] args)
	{

		int[] arr = { 1, 2, 3, 4 };

		ListNode head = new ListNode(arr);
		System.out.println(head);

		ListNode node2 = head.findNode(2);
		(new LeetCode237()).deleteNode(node2);
		System.out.println(head);
	}
}
