package datastructure.tree_old;

public class TreeTest
{

	public static void main(String[] args)
	{
		/*
		 * //根节点-->10 TreeNode treeNode1 = new TreeNode(10);
		 * 
		 * //左孩子-->9 TreeNode treeNode2 = new TreeNode(9);
		 * 
		 * //右孩子-->20 TreeNode treeNode3 = new TreeNode(20);
		 * 
		 * //20的左孩子-->15 TreeNode treeNode4 = new TreeNode(15);
		 * 
		 * //20的右孩子-->35 TreeNode treeNode5 = new TreeNode(35);
		 * 
		 * //根节点的左右孩子 treeNode1.setLefTreeNode(treeNode2);
		 * treeNode1.setRightNode(treeNode3);
		 * 
		 * //20节点的左右孩子 treeNode3.setLefTreeNode(treeNode4);
		 * treeNode3.setRightNode(treeNode5);
		 * 
		 * preTraverseBTree(treeNode1);
		 */

		int[] arrays = { 3, 2, 7, 4, 5 };
		// int[] arrays2 = {6, 3, 8, 2, 5, 1, 7};

		// 动态创建树

		TreeRoot root = new TreeRoot();
		for (int value : arrays)
		{
			createTree(root, value);
		}

		// 先序遍历树
		preTraverseBTree(root.getTreeRoot());

		// 中序遍历树
		inTraverseBTree(root.getTreeRoot());

		System.out.println("树的深度是：" + getHeight(root.getTreeRoot()));

		System.out.println("树的最大值是：" + getMax(root.getTreeRoot()));

	}

	/**
	 * 动态创建二叉查找树
	 *
	 * @param treeRoot
	 *            根节点
	 * @param value
	 *            节点的值
	 */
	public static void createTree(TreeRoot treeRoot, int value)
	{

		// 如果树根为空(第一次访问)，将第一个值作为根节点
		if (treeRoot.getTreeRoot() == null)
		{
			TreeNode treeNode = new TreeNode(value);
			treeRoot.setTreeRoot(treeNode);

		} else
		{

			// 当前树根
			TreeNode tempRoot = treeRoot.getTreeRoot();

			while (tempRoot != null)
			{
				// 当前值大于根值，往右边走
				if (value > tempRoot.getValue())
				{

					// 右边没有树根，那就直接插入
					if (tempRoot.getRightNode() == null)
					{
						tempRoot.setRightNode(new TreeNode(value));
						return;
					} else
					{
						// 如果右边有树根，到右边的树根去
						tempRoot = tempRoot.getRightNode();
					}
				} else
				{
					// 左没有树根，那就直接插入
					if (tempRoot.getLefTreeNode() == null)
					{
						tempRoot.setLefTreeNode(new TreeNode(value));

						return;
					} else
					{
						// 如果左有树根，到左边的树根去
						tempRoot = tempRoot.getLefTreeNode();
					}
				}
			}
		}
	}

	public static int getHeight(TreeNode treeNode)
	{

		if (treeNode == null)
		{
			return 0;
		} else
		{

			// 左边的子树深度
			int left = getHeight(treeNode.getLefTreeNode());

			// 右边的子树深度
			int right = getHeight(treeNode.getRightNode());

			int max = left;

			if (right > max)
			{
				max = right;
			}
			return max + 1;
		}
	}

	/**
	 * 找出树的最大值
	 *
	 * @param rootTreeNode
	 */
	public static int getMax(TreeNode rootTreeNode)
	{

		if (rootTreeNode == null)
		{
			return -1;
		} else
		{
			// 找出左边的最大值
			int left = getMax(rootTreeNode.getLefTreeNode());

			// 找出右边的最大值
			int right = getMax(rootTreeNode.getRightNode());

			// 与当前根节点比较
			int currentRootValue = rootTreeNode.getValue();

			// 假设左边的最大
			int max = left;

			if (right > max)
			{
				max = right;
			}
			if (currentRootValue > max)
			{
				max = currentRootValue;
			}

			return max;

		}
	}

	/**
	 * 中序遍历
	 *
	 * @param rootTreeNode
	 *            根节点
	 */
	public static void inTraverseBTree(TreeNode rootTreeNode)
	{

		if (rootTreeNode != null)
		{

			// 访问根节点
			System.out.println(rootTreeNode.getValue());

			// 访问左节点
			inTraverseBTree(rootTreeNode.getLefTreeNode());

			// 访问右节点
			inTraverseBTree(rootTreeNode.getRightNode());
		}
	}

	/**
	 * 先序遍历
	 *
	 * @param rootTreeNode
	 *            根节点
	 */
	public static void preTraverseBTree(TreeNode rootTreeNode)
	{

		if (rootTreeNode != null)
		{

			// 访问左节点
			preTraverseBTree(rootTreeNode.getLefTreeNode());

			// 访问根节点
			System.out.println(rootTreeNode.getValue());

			// 访问右节点
			preTraverseBTree(rootTreeNode.getRightNode());
		}
	}

}
