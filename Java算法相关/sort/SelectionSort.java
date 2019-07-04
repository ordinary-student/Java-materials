package sort;

public class SelectionSort
{

	public void sort()
	{

		int[] arrays = { 2, 3, 1, 4, 3, 5, 1, 6, 1, 2, 3, 7, 2, 3 };

		// 记录当前趟数的最大值的角标
		int pos;

		// 交换的变量
		int temp;

		// 外层循环控制需要排序的趟数
		for (int i = 0; i < arrays.length - 1; i++)
		{

			// 新的趟数、将角标重新赋值为0
			pos = 0;

			// 内层循环控制遍历数组的个数并得到最大数的角标
			for (int j = 0; j < arrays.length - i; j++)
			{

				if (arrays[j] > arrays[pos])
				{
					pos = j;
				}

			}
			// 交换
			temp = arrays[pos];
			arrays[pos] = arrays[arrays.length - 1 - i];
			arrays[arrays.length - 1 - i] = temp;

		}

		System.out.println(arrays);
	}
}
