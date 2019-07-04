package LeetCode;

public class LeetCode137_no
{

	// 思路：其他元素都出现了三次，按位计算每一位上1的个数，结果模3为1的那些位就是所求数二进制1所在的位。
	// 出处：https://blog.csdn.net/w8253497062015/article/details/80058180
	public static int singleNumber(int[] nums)
	{
		int result = 0;
		for (int i = 0; i < 32; i++)
		{
			int mask = 1 << i;
			int count = 0;
			for (int j = 0; j < nums.length; j++)
			{
				if ((mask & nums[j]) != 0)
					count++;
			}
			if (count % 3 == 1)
				result = mask | result;
		}
		return result;
	}

}
