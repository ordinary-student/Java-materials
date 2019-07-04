package sort;

public class InsertSort
{

	public static void main(String[] args)
	{
		int[] arrays = { 9, 8, 1, 4, 2, 3, 5, 6, 7, 13, 12, 14, 11, 15, 16, 17, 19, 18, 10 };

		sort2(arrays);

		System.out.println(arrays);
	}

	/**
	 * 插入排序普通版
	 * 
	 * @param arrays
	 */
	public static void sort(int[] arrays)
	{

		// 临时变量
		int temp;

		// 外层循环控制需要排序的趟数(从1开始因为将第0位看成了有序数据)
		for (int i = 1; i < arrays.length; i++)
		{

			temp = arrays[i];

			// 如果前一位(已排序的数据)比当前数据要大，那么就进入循环比较[参考第二趟排序]
			int j = i - 1;

			while (j >= 0 && arrays[j] > temp)
			{

				// 往后退一个位置，让当前数据与之前前位进行比较
				arrays[j + 1] = arrays[j];

				// 不断往前，直到退出循环
				j--;

			}
			// 退出了循环说明找到了合适的位置了，将当前数据插入合适的位置中
			arrays[j + 1] = temp;

		}
		System.out.println(arrays);
	}

	/**
	 * 二分插入排序:插入到有序的位置时，使用二分法查找出对应的index，避免多次移动
	 * 
	 * @param arrays
	 */
	public static void sort2(int[] arrays)
	{

		// 临时变量
		int temp;

		// 外层循环控制需要排序的趟数(从1开始因为将第0位看成了有序数据)
		for (int i = 1; i < arrays.length; i++)
		{

			// 二分查找找出合适的插入位置
			int index = BinarySearchIndex(arrays, i - 1, arrays[i]);

			// 如果不是直接插入，那么就要移动位置了
			if (index != i)
			{

				temp = arrays[i];

				int j;

				// 后移元素，腾出arr[index]位置
				for (j = i - 1; j >= index && j >= 0; j--)
				{

					arrays[j + 1] = arrays[j];

				}
				arrays[j + 1] = temp;
			}

		}
		System.out.println(arrays);
	}

	private static int BinarySearchIndex(int[] arr, int maxIndex, int data)
	{

		// 定义三个指针，分别为待查找区域的两端和中心位置，这个对应的是有序区的大小，不是 整个数组
		int left = 0;
		int right = maxIndex;
		int mid;

		// 只要左边和右边指针没相撞，那么就可以找
		while (left <= right)
		{

			// 取中间数
			mid = (left + right) / 2;

			// 比中间数大的或者等于中间数，往右边找
			if (data >= arr[mid])
			{

				// 这里包括了等于的情况--->如果等于，角标+1，那么则是直接插入
				left = mid + 1;
			} else
			{
				// 比中间数小的，往左边找
				right = mid - 1;
			}
		}

		// 角标相撞了才结束循环..
		return left;
	}

}
