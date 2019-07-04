package sort;

public class HeapifySort
{
	public static void main(String[] args)
	{

		int[] arrays = { 6, 3, 8, 5, 2, -1, -5, -2, -6, 345, 7, 5, 1, 2, 23, 4321, 432, 3, 2, 34234, 2134, 1234, 5,
				132423, 234, 4, 2, 4, 1, 5, 2, 5 };

		// 完成一次建堆..
		maxHeapify(arrays, arrays.length - 1);

		int size = arrays.length - 1;

		for (int i = 0; i < arrays.length; i++)
		{
			// 交换
			int temp = arrays[0];
			arrays[0] = arrays[(arrays.length - 1) - i];
			arrays[(arrays.length - 1) - i] = temp;

			// 调整位置
			heapify(arrays, 0, size);
			size--;
		}
		System.out.println(arrays);
	}

	/**
	 * 完成一次建堆，最大值在堆的顶部(根节点)
	 */
	public static void maxHeapify(int[] arrays, int size)
	{
		for (int i = size - 1; i >= 0; i--)
		{
			heapify(arrays, i, size);
		}
	}

	/**
	 * 建堆
	 *
	 * @param arrays
	 *            看作是完全二叉树
	 * @param currentRootNode
	 *            当前父节点位置
	 * @param size
	 *            节点总数
	 */
	public static void heapify(int[] arrays, int currentRootNode, int size)
	{

		if (currentRootNode < size)
		{
			// 左子树和右字数的位置
			int left = 2 * currentRootNode + 1;
			int right = 2 * currentRootNode + 2;

			// 把当前父节点位置看成是最大的
			int max = currentRootNode;

			if (left < size)
			{
				// 如果比当前根元素要大，记录它的位置
				if (arrays[max] < arrays[left])
				{
					max = left;
				}
			}
			if (right < size)
			{
				// 如果比当前根元素要大，记录它的位置
				if (arrays[max] < arrays[right])
				{
					max = right;
				}
			}
			// 如果最大的不是根元素位置，那么就交换
			if (max != currentRootNode)
			{
				int temp = arrays[max];
				arrays[max] = arrays[currentRootNode];
				arrays[currentRootNode] = temp;

				// 继续比较，直到完成一次建堆
				heapify(arrays, max, size);
			}
		}
	}

}
