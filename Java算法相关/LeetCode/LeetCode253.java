package LeetCode;

public class LeetCode253
{

	/// 235. Lowest Common Ancestor of a Binary Search Tree
	/// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
	/// 时间复杂度: O(lgn), 其中n为树的节点个数
	/// 空间复杂度: O(h), 其中h为树的高度

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

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
	{

		if (p == null || q == null)
			throw new IllegalArgumentException("p or q can not be null.");

		if (root == null)
			return null;

		// p q 都在root左边
		if (p.val < root.val && q.val < root.val)
			return lowestCommonAncestor(root.left, p, q);

		// p q 都在root右边
		if (p.val > root.val && q.val > root.val)
			return lowestCommonAncestor(root.right, p, q);

		assert p.val == root.val || q.val == root.val || (root.val - p.val) * (root.val - q.val) < 0;

		// 某个节点是root，直接返回root
		return root;
	}

}
