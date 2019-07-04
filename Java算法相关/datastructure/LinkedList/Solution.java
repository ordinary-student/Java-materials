package datastructure.LinkedList;

import java.util.ArrayList;
import java.util.List;

import javafx.util.Pair;

class Solution
{

	private class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x)
		{
			val = x;
		}
	}

	private interface Queue<E>
	{

		int getSize();

		boolean isEmpty();

		void enqueue(E e);

		E dequeue();

		E getFront();
	}

	private class LinkedListQueue<E> implements Queue<E>
	{

		private class Node
		{
			public E e;
			public Node next;

			public Node(E e, Node next)
			{
				this.e = e;
				this.next = next;
			}

			public Node(E e)
			{
				this(e, null);
			}

			public Node()
			{
				this(null, null);
			}

			@Override
			public String toString()
			{
				return e.toString();
			}
		}

		private Node head, tail;
		private int size;

		public LinkedListQueue()
		{
			head = null;
			tail = null;
			size = 0;
		}

		@Override
		public int getSize()
		{
			return size;
		}

		@Override
		public boolean isEmpty()
		{
			return size == 0;
		}

		@Override
		public void enqueue(E e)
		{
			if (tail == null)
			{
				tail = new Node(e);
				head = tail;
			} else
			{
				tail.next = new Node(e);
				tail = tail.next;
			}
			size++;
		}

		@Override
		public E dequeue()
		{
			if (isEmpty())
				throw new IllegalArgumentException("Cannot dequeue from an empty queue.");

			Node retNode = head;
			head = head.next;
			retNode.next = null;
			if (head == null)
				tail = null;
			size--;
			return retNode.e;
		}

		@Override
		public E getFront()
		{
			if (isEmpty())
				throw new IllegalArgumentException("Queue is empty.");
			return head.e;
		}

		@Override
		public String toString()
		{
			StringBuilder res = new StringBuilder();
			res.append("Queue: front ");

			Node cur = head;
			while (cur != null)
				res.append(cur + "->");
			res.append("NULL tail");
			return res.toString();
		}
	}

	public List<List<Integer>> levelOrder(TreeNode root)
	{

		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null)
			return res;

		// 我们使用LinkedList来做为我们的先入先出的队列
		LinkedListQueue<Pair<TreeNode, Integer>> queue = new LinkedListQueue<Pair<TreeNode, Integer>>();
		queue.enqueue(new Pair<TreeNode, Integer>(root, 0));

		while (!queue.isEmpty())
		{

			Pair<TreeNode, Integer> front = queue.dequeue();
			TreeNode node = front.getKey();
			int level = front.getValue();

			if (level == res.size())
				res.add(new ArrayList<Integer>());
			assert level < res.size();

			res.get(level).add(node.val);
			if (node.left != null)
				queue.enqueue(new Pair<TreeNode, Integer>(node.left, level + 1));
			if (node.right != null)
				queue.enqueue(new Pair<TreeNode, Integer>(node.right, level + 1));
		}

		return res;
	}
}