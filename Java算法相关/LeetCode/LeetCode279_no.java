package LeetCode;

import java.util.LinkedList;

import javafx.util.Pair;

public class LeetCode279_no
{

	// 279. Perfect Squares
	// https://leetcode.com/problems/perfect-squares/description/
	// 该方法会导致 Time Limit Exceeded 或者 Memory Limit Exceeded
	//
	// 时间复杂度: O(2^n)
	// 空间复杂度: O(2^n)
	public int numSquares(int n)
	{

		LinkedList<Pair<Integer, Integer>> queue = new LinkedList<Pair<Integer, Integer>>();
		queue.addLast(new Pair<Integer, Integer>(n, 0));

		while (!queue.isEmpty())
		{
			Pair<Integer, Integer> front = queue.removeFirst();
			int num = front.getKey();
			int step = front.getValue();

			if (num == 0)
				return step;

			for (int i = 1; num - i * i >= 0; i++)
				queue.addLast(new Pair(num - i * i, step + 1));
		}

		throw new IllegalStateException("No Solution.");
	}

	// 使用visited数组,记录每一个入队元素
	// 时间复杂度: O(n)
	// 空间复杂度: O(n)
	public int numSquares2(int n)
	{

		LinkedList<Pair<Integer, Integer>> queue = new LinkedList<Pair<Integer, Integer>>();
		queue.addLast(new Pair<Integer, Integer>(n, 0));

		boolean[] visited = new boolean[n + 1];
		visited[n] = true;

		while (!queue.isEmpty())
		{
			Pair<Integer, Integer> front = queue.removeFirst();
			int num = front.getKey();
			int step = front.getValue();

			if (num == 0)
				return step;

			for (int i = 1; num - i * i >= 0; i++)
				if (!visited[num - i * i])
				{
					queue.addLast(new Pair(num - i * i, step + 1));
					visited[num - i * i] = true;
				}
		}

		throw new IllegalStateException("No Solution.");
	}

	// 时间复杂度: O(n)
	// 空间复杂度: O(n)
	public int numSquares3(int n)
	{

		if (n == 0)
			return 0;

		LinkedList<Pair<Integer, Integer>> queue = new LinkedList<Pair<Integer, Integer>>();
		queue.addLast(new Pair<Integer, Integer>(n, 0));

		boolean[] visited = new boolean[n + 1];
		visited[n] = true;

		while (!queue.isEmpty())
		{
			Pair<Integer, Integer> front = queue.removeFirst();
			int num = front.getKey();
			int step = front.getValue();

			if (num == 0)
				return step;

			for (int i = 1; num - i * i >= 0; i++)
			{
				int a = num - i * i;
				if (!visited[a])
				{
					if (a == 0)
						return step + 1;
					queue.addLast(new Pair(num - i * i, step + 1));
					visited[num - i * i] = true;
				}
			}
		}

		throw new IllegalStateException("No Solution.");
	}

	public static void main(String[] args)
	{

		System.out.println((new LeetCode279_no()).numSquares(12));
		System.out.println((new LeetCode279_no()).numSquares(13));
	}
}
