/**
 * 
 */
public class ArithmeticOne
{

	public static void main(String[] args)
	{
		Factorial(7);
	}

	/**
	 * 判断一个数字是不是ugly number（分解出来的质因数只有2、3、5这3个数字）
	 *
	 * @param num
	 */
	public static void isUgly(int num)
	{
		if (num <= 0)
		{
			System.out.println("不是");
		} else
		{
			while (num % 2 == 0)
			{
				num = num / 2;
			}
			
			while (num % 3 == 0)
			{
				num = num / 3;
			}
			
			while (num % 5 == 0)
			{
				num = num / 5;
			}
			
			if (num == 1)
			{
				System.out.println("是");

			} else
			{
				System.out.println("是");

			}
		}
	}

	/**
	 * 判断是否是2的某次方
	 */
	public static void isPowerOfTwo()
	{

		int num = 8;
		
		if (num <= 0)
		{
			System.out.println("不是");
		} else if (num == 1)
		{
			System.out.println("是");
		} else
		{
			if ((num & (num - 1)) == 0)
			{
				System.out.println("是");
			} else
			{
				System.out.println("不是");
			}
		}
	}

	/**
	 * 给定两个字符串s和t，判断这两个字符串中的字母是不是完全一样（顺序可以不一样）
	 */
	public static void isAnagram()
	{

		// 分别存储字符串的字符
		char[] array1 = new char[26];
		char[] array2 = new char[26];

		String s1 = "pleasefollowthewechatpublicnumber";
		String s2 = "pleowcnumberthewechatpubliasefoll";

		for (int i = 0; i < s1.length(); i++)
		{
			char value = s1.charAt(i);

			// 算出要存储的位置
			int index = value - 'a';

			array1[index]++;
		}

		for (int i = 0; i < s2.length(); i++)
		{
			char value = s2.charAt(i);

			// 算出要存储的位置
			int index = value - 'a';

			array2[index]++;
		}

		for (int i = 0; i < 26; i++)
		{
			if (array1[i] != array2[i])
			{
				System.out.println("不相同");
				return;
			}
		}

		System.out.println("相同");

	}

	/**
	 * 输入一段字符，计算出里面单词的个数
	 *
	 * @param str
	 *            一段文字
	 */
	public static int countWord(String str)
	{

		// 0 表示空格状态，1 表示非空格状态
		int flag = 0;

		// 单词次数
		int num = 0;

		for (int i = 0; i < str.length(); i++)
		{

			if (String.valueOf(str.charAt(i)).equals(" "))
			{
				flag = 0;
			} else if (flag == 0)
			{
				num++;
				flag = 1;
			}

		}

		return num;

	}

	/**
	 * 猴子吃桃问题
	 *
	 * @param x
	 *            天数
	 */
	public static int monkeyQue(int x)
	{

		if (x <= 0)
		{
			return 0;

		} else if (x == 1)
		{
			return 1;

		} else
		{

			return 2 * monkeyQue(x - 1) + 2;
		}

	}

	/**
	 * 打印杨辉三角形
	 */
	public static void PascalTriangle()
	{

		// 打印十行的杨辉三角形
		int[][] arrays = new int[10][];

		// 行数
		for (int i = 0; i < arrays.length; i++)
		{

			// 初始化第二层的大小
			arrays[i] = new int[i + 1];

			// 列数
			for (int j = 0; j <= i; j++)
			{

				// 是第一列并且行数等于列数，那么通通为1
				if (i == 0 || j == 0 || j == i)
				{
					arrays[i][j] = 1;
				} else
				{

					// 当前值等于头上的值+头上左边的值
					arrays[i][j] = arrays[i - 1][j] + arrays[i - 1][j - 1];
				}

			}
		}


		for (int[] array : arrays)
		{
			for (int value : array)
			{
				System.out.print(value + "\t");
			}
			System.out.println();

		}

	}

	/**
	 * 数组对角线之和
	 */
	public static void arraySum()
	{

		int[][] arrays = { { 23, 106, 8, 234 }, { 25, 9, 73, 19 }, { 56, 25, 67, 137 }, { 33, 22, 11, 44 }, };

		// 和
		int sum = 0;

		for (int i = 0; i < arrays.length; i++)
		{

			for (int j = 0; j < arrays[i].length; j++)
			{

				if (i == j)
				{

					sum = sum + arrays[i][j];

				}
			}
		}

		System.out.println(sum);

	}

	/**
	 * 1-n的阶乘之和
	 */
	public static void Factorial(int n)
	{

		// 总和
		double sum = 0;

		// 阶乘值，初始化为1
		double factorial = 1;

		for (int i = 1; i <= n; i++)
		{

			factorial = factorial * i;

			sum = (int) (sum + factorial);

		}

		System.out.println(sum);

	}

	/**
	 * 求出二维数组每列的最小值
	 */
	public static void minArray()
	{

		// 二维数组
		int[][] arrays = { { 23, 106, 8, 234 }, { 25, 9, 73, 19 }, { 56, 25, 67, 137 } };

		// 获取列数
		int maxColLength = arrays[0].length;

		// 使用一个数组来装载每列最小的值
		int[] minArray = new int[maxColLength];

		// 控制列数
		for (int i = 0; i < maxColLength; i++)
		{

			// 假设每列的第一个元素是最小的
			int min = arrays[0][i];

			// 控制行数
			for (int j = 1; j < arrays.length; j++)
			{

				// 找到最小值
				if (arrays[j][i] < min)
				{
					min = arrays[j][i];
				}
			}

			// 赋值给装载每列最小的值的数组
			minArray[i] = min;
		}

		System.out.println( minArray);

	}

	/**
	 * 求"1！+4！(2的平方)+9！(3的平方)+...+n的值
	 */
	public static void calculate()
	{

		double sum = 0;

		for (int i = 1; i <= 3; i++)
		{

			// 得到平方数
			int square = i * i;

			// 阶乘值，从1开始
			double factorial = 1;

			// 求阶乘
			for (int j = 1; j <= square; j++)
			{
				factorial = factorial * j;
			}

			sum = sum + factorial;

		}

		System.out.println( sum);

	}

}
