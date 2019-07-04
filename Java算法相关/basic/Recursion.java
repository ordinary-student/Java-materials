
public class Recursion
{

	public static void main(String[] args)
	{

		int[] arrays = { 1, 1, 2, 3, 5, 8, 13, 21 };
	
		hanoi(3, 'A', 'B', 'C');

	}

	/**
	 * 汉诺塔
	 * 
	 * @param n
	 *            n个盘子
	 * @param start
	 *            起始柱子
	 * @param transfer
	 *            中转柱子
	 * @param target
	 *            目标柱子
	 */
	public static void hanoi(int n, char start, char transfer, char target)
	{

		// 只有一个盘子，直接搬到目标柱子
		if (n == 1)
		{
			System.out.println(start + "---->" + target);
		} else
		{

			// 起始柱子借助目标柱子将盘子都移动到中转柱子中(除了最大的盘子)
			hanoi(n - 1, start, target, transfer);
			System.out.println(start + "---->" + target);

			// 中转柱子借助起始柱子将盘子都移动到目标柱子中
			hanoi(n - 1, transfer, start, target);

		}
	}

	/**
	 * 费波纳切数列
	 * 
	 * @param n
	 * @return
	 */
	public static int fibonacci(int n)
	{
		if (n == 1)
		{
			return 1;
		} else if (n == 2)
		{
			return 1;
		} else
		{
			return (fibonacci(n - 1) + fibonacci(n - 2));
		}

	}

	public static void bubbleSort(int[] arrays, int L, int R)
	{

		int temp;

		// 如果只有一个元素了，那什么都不用干
		if (L == R)
			;

		else
		{
			for (int i = L; i < R; i++)
			{
				if (arrays[i] > arrays[i + 1])
				{
					temp = arrays[i];
					arrays[i] = arrays[i + 1];
					arrays[i + 1] = temp;
				}
			}

			// 第一趟排序后已经将最大值放到数组最后面了

			// 接下来是排序"整体"的数据了
			bubbleSort(arrays, L, R - 1);

		}
	}

	/**
	 * 递归，找出数组最大的值
	 *
	 * @param arrays
	 *            数组
	 * @param L
	 *            左边界，第一个数
	 * @param R
	 *            右边界，数组的长度
	 * @return
	 */

	public static int findMax(int[] arrays, int L, int R)
	{

		// 如果该数组只有一个数，那么最大的就是该数组第一个值了
		if (L == R)
		{
			return arrays[L];
		} else
		{

			int a = arrays[L];
			int b = findMax(arrays, L + 1, R);// 找出整体的最大值

			if (a > b)
			{
				return a;
			} else
			{
				return b;
			}
		}

	}

	/**
	 * 递归，1+2+3+4+....+100(n)
	 *
	 * @param n
	 *            要加到的数字，比如题目的100
	 * @return
	 */
	public static int sum(int n)
	{

		if (n == 1)
		{
			return 1;
		} else
		{
			return sum(n - 1) + n;
		}
	}

}
