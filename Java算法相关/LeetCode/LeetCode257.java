package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode257
{

	/// 257. Binary Tree Paths
	/// https://leetcode.com/problems/binary-tree-paths/description/
	/// 时间复杂度: O(n), n为树中的节点个数
	/// 空间复杂度: O(h), h为树的高度

	// Definition for a binary tree node.
	public class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x)
		{
			val = x;
		}
	}

	/**
	 * 从底一直往上加
	 * 
	 * @param root
	 * @return
	 */
	public List<String> binaryTreePaths(TreeNode root)
	{

		ArrayList<String> res = new ArrayList<>();

		if (root == null)
			return res;

		// 比如 1
		// /
		// 2

		if (root.left == null && root.right == null)
		{
			res.add(Integer.toString(root.val));
			return res;
		}

		List<String> leftPaths = binaryTreePaths(root.left);
		for (String s : leftPaths)
		{
			StringBuilder sb = new StringBuilder(Integer.toString(root.val));
			sb.append("->");
			sb.append(s);
			res.add(sb.toString());
		}

		List<String> rightPaths = binaryTreePaths(root.right);
		for (String s : rightPaths)
		{
			StringBuilder sb = new StringBuilder(Integer.toString(root.val));
			sb.append("->");
			sb.append(s);
			res.add(sb.toString());
		}

		return res;
	}
}
