package LeetCode;

import java.util.LinkedList;
import java.util.List;

public class LeetCode113
{

	public class TreeNode
	{
		int val;
		LeetCode113.TreeNode left;
		LeetCode113.TreeNode right;

		TreeNode(int x)
		{
			val = x;
		}
	}

	class Solution
	{
		public List<List<Integer>> pathSum(TreeNode root, int sum)
		{
			List<List<Integer>> ans = new LinkedList<>();
			List<Integer> result = new LinkedList<>();
			path(root, sum, ans, result);
			return ans;
		}

		public void path(TreeNode root, int sum, List<List<Integer>> ans, List<Integer> result)
		{
			if (root == null)
				return;

			// 先放入temp中
			result.add(new Integer(root.val));

			if (root.left == null && root.right == null && sum == root.val)
			{

				// 如果是叶子节点，条件也符合，放入结果中
				ans.add(new LinkedList(result));

				/*
				 * result.remove(result.size() - 1); return;
				 */
			} else
			{
				path(root.left, sum - root.val, ans, result);
				path(root.right, sum - root.val, ans, result);

				// 如果不符合，则去除
				result.remove(result.size() - 1);

			}

		}
	}
}
