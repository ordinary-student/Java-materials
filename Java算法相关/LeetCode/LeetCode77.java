package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode77
{

	// https://leetcode-cn.com/problems/combinations/description/

	/// 时间复杂度: O(n^k)
	/// 空间复杂度: O(k)

	private ArrayList<List<Integer>> res;

	public List<List<Integer>> combine(int n, int k)
	{

		res = new ArrayList<>();
		if (n <= 0 || k <= 0 || k > n)
			return res;

		LinkedList<Integer> c = new LinkedList<>();
		generateCombinations(n, k, 1, c);

		return res;
	}

	// 求解C(n,k), 当前已经找到的组合存储在c中, 需要从start开始搜索新的元素
	private void generateCombinations(int n, int k, int start, LinkedList<Integer> c)
	{

		if (c.size() == k)
		{
			res.add((List<Integer>) c.clone());
			return;
		}
		for (int i = start; i <= n; i++)
		{
			c.addLast(i);
			generateCombinations(n, k, i + 1, c);
			c.removeLast();
		}

		return;
	}

	// 求解C(n,k), 当前已经找到的组合存储在c中, 需要从start开始搜索新的元素
	private void generateCombinations2(int n, int k, int start, LinkedList<Integer> c)
	{

		if (c.size() == k)
		{
			res.add((List<Integer>) c.clone());
			return;
		}

		// 还有k - c.size()个空位, 所以, [i...n] 中至少要有 k - c.size() 个元素
		// i最多为 n - (k - c.size()) + 1
		// 这种优化叫做截枝
		for (int i = start; i <= n - (k - c.size()) + 1; i++)
		{
			c.addLast(i);
			generateCombinations2(n, k, i + 1, c);
			c.removeLast();
		}

		return;
	}

	private static void printList(List<Integer> list)
	{
		for (Integer e : list)
			System.out.print(e + " ");
		System.out.println();
	}

	public static void main(String[] args)
	{

		List<List<Integer>> res = (new LeetCode77()).combine(4, 2);
		for (List<Integer> list : res)
			printList(list);
	}
}
