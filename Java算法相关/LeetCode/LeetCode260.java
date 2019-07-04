package LeetCode;

public class LeetCode260
{

	// 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
	// https://leetcode-cn.com/problems/single-number-iii/description/

	public int[] singleNumber(int[] nums)
	{
		int sum = 0; // 记录所有异或的值，即两个只出现一次数的异或
		for (int i = 0; i < nums.length; i++)
		{
			sum ^= nums[i];
		}
		int[] res = new int[2];

		sum &= -sum; // 得出两个数异或结果的最右边的一个1，其他的为零，这样进行&操作就可以将两个不同的数分到不同的两组去
		for (int i = 0; i < nums.length; i++)
		{
			if ((sum & nums[i]) == 0)
				res[0] ^= nums[i];
			else
				res[1] ^= nums[i];
		}
		return res;
	}

}
