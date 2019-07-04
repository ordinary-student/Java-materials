package sort;

import java.util.Stack;

/**
 * Created by ozc on 2018/3/17.
 *
 * @author ozc
 * @version 1.0
 */
public class QuickSort
{

	public static void main(String[] args)
	{
		// int[] arr = {1, 4, 5, 67, 2, 7, 8, 6, 9, 44, 34, 5, 5, 2, 34, 5, 62, 42, 1,
		// 1324, 2346};
		int[] arr = { 23, 34, 33, 56, 45 };
		quickSort(arr, 0, arr.length - 1);

		System.out.println("Java3y   " + arr);
	}

	/**
	 * 快速排序
	 *
	 * @param arr
	 * @param L
	 *            指向数组第一个元素
	 * @param R
	 *            指向数组最后一个元素
	 */
	public static void quickSort(int[] arr, int L, int R)
	{
		int i = L;
		int j = R;

		// 支点
		int pivot = arr[(L + R) / 2];

		// 左右两端进行扫描，只要两端还没有交替，就一直扫描
		while (i <= j)
		{

			// 寻找直到比支点大的数
			while (pivot > arr[i])
				i++;

			// 寻找直到比支点小的数
			while (pivot < arr[j])
				j--;

			// 此时已经分别找到了比支点小的数(右边)、比支点大的数(左边)，它们进行交换
			if (i <= j)
			{
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
		// 上面一个while保证了第一趟排序支点的左边比支点小，支点的右边比支点大了。

		// “左边”再做排序，直到左边剩下一个数(递归出口)
		if (L < j)
			quickSort(arr, L, j);

		// “右边”再做排序，直到右边剩下一个数(递归出口)
		if (i < R)
			quickSort(arr, i, R);
	}

	// -----------------Stack方式实现快速排序
	public static void print(int[] arr)
	{
		for (int n = 0; n < arr.length; n++)
		{
			System.out.print(arr[n] + " ");
		}
		System.out.println();
	}

	public static void fun(int[] a, int low, int high)
	{
		Stack<Integer> stack = new Stack<>();
		if (low < high)
		{
			stack.add(low);
			stack.add(high);
			while (!stack.isEmpty())
			{
				int hi = stack.pop();
				int lo = stack.pop();
				int key = partition(a, lo, hi);
				if (lo < key - 1)
				{
					stack.push(lo);
					stack.push(key - 1);
				}
				if (hi > key)
				{
					stack.push(key + 1);
					stack.push(hi);// 这样，最后入栈的就是key右边的部分，则下一次循环先处理key右边的部分
				}
			}
		}
	}

	public static int partition(int[] a, int low, int high)
	{

		// 选第一个元素作为key
		int key = a[low];

		while (low < high)
		{

			// 右边找到比key还要小的
			while (a[high] >= key && low < high)
			{
				high--;
			}

			a[low] = a[high];

			// 左边找到比key要大的
			while (a[low] <= key && low < high)
			{// 小于于等于key的数组元素不需要移动
				low++;
			}
			a[high] = a[low];
		}
		a[low] = key;
		print(a);
		return low;
	}
}
