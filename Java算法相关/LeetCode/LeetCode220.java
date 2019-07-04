package LeetCode;

import java.util.TreeSet;

public class LeetCode220
{

	// 220. Contains Duplicate III
	// https://leetcode.com/problems/contains-duplicate-iii/description/
	// 时间复杂度: O(nlogk)
	// 空间复杂度: O(k)

	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t)
	{

		// 这个问题的测试数据在使用int进行加减运算时会溢出
		// 所以使用long long
		TreeSet<Long> record = new TreeSet<Long>();

		// nums = [1,2,3,1], k = 3, t = 0 true
		// nums = [1,5,9,1,5,9], k = 2, t = 3 false

		for (int i = 0; i < nums.length; i++)
		{

			// ceiling 向上取整,ceiling会去查找在set中有没有该值，如果没有--->null
			if (record.ceiling((long) nums[i] - (long) t) != null
					&& record.ceiling((long) nums[i] - (long) t) <= (long) nums[i] + (long) t)
				return true;

			record.add((long) nums[i]);

			if (record.size() == k + 1)
				record.remove((long) nums[i - k]);
		}

		return false;
	}

	public static void main(String[] args)
	{
		int[] nums = { 1, 3, 2, 1 };

		int k = 3, t = 0;

		containsNearbyAlmostDuplicate(nums, k, t);

	}
}
