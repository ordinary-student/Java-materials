package LeetCode;

public class LeetCode104
{

	// 104. Maximum Depth of Binary Tree
	// https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
	// 时间复杂度: O(n), n是树中的节点个数
	// 空间复杂度: O(h), h是树的高度

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

	public int maxDepth(TreeNode root)
	{

		if (root == null)
			return 0;

		// 递归！！！！
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}
}
