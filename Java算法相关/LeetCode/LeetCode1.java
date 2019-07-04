package LeetCode;

import java.util.HashMap;

public class LeetCode1
{

	// 1. Two Sum
	// https://leetcode.com/problems/two-sum/description/
	// 时间复杂度：O(n)
	// 空间复杂度：O(n)

	public int[] twoSum(int[] nums, int target)
	{

		HashMap<Integer, Integer> record = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++)
		{
			int complement = target - nums[i];
			if (record.containsKey(complement))
			{
				int[] res = { i, record.get(complement) };
				return res;
			}
			record.put(nums[i], i);
		}

		throw new IllegalStateException("the input has no solution");
	}

	// 由于题目中只要求求出唯一的一个解。因此可以在最初的时候遍历整个数组, 将数组中的每个数字的索引放在map中。
	// 此时, record中记录的永远是每一个数字最后出现的位置。
	// 而对于 target = 2*a的情况, 如果nums中有两个或两个以上a,
	// 我们在扫描时会先看到第一个a, 而从record中拿到的是最后一个a :)
	public int[] twoSum2(int[] nums, int target)
	{

		HashMap<Integer, Integer> record = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++)
			record.put(nums[i], i);

		for (int i = 0; i < nums.length; i++)
		{
			if (record.containsKey(target - nums[i]))
				// 针对只有一个解，所以可以用索引的方式判断(但还是用值来判断易懂一些)...
				if (record.get(target - nums[i]) != i)
				{
					int[] res = { i, record.get(target - nums[i]) };
					return res;
				}

			record.put(nums[i], i);
		}

		throw new IllegalStateException("the input has no solution");
	}
}
