package LeetCode;

public class LeetCode226
{

	/// 226. Invert Binary Tree
	/// https://leetcode.com/problems/invert-binary-tree/description/
	/// 时间复杂度: O(n), n为树中节点个数
	/// 空间复杂度: O(h), h为树的高度

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

	public TreeNode invertTree(TreeNode root)
	{

		if (root == null)
			return null;

		// 左边翻转，右边翻转
		TreeNode left = invertTree(root.left);
		TreeNode right = invertTree(root.right);

		// 左右交换！
		root.left = right;
		root.right = left;

		return root;
	}
}
