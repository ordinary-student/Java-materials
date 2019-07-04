package LeetCode;

public class LeetCode112
{

	/// 112. Path Sum
	/// https://leetcode.com/problems/path-sum/description/
	/// 时间复杂度: O(n), n为树的节点个数
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

	// 从根节点到叶子节点，有没有路径为sum
	// 确定了根节点是必须要的，那我们就可以分解成
	// 根节点下的子节点，有没有路径为sum - root.val!!!(其实就是子问题)
	public boolean hasPathSum(TreeNode root, int sum)
	{

		if (root == null)
			return false;

		// 根节点到叶子节点，所以递归的出口是叶子节点
		if (root.left == null && root.right == null)
			return sum == root.val;

		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}
}
