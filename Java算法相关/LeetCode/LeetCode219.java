package LeetCode;

import java.util.HashSet;

public class LeetCode219
{

	// https://leetcode.com/problems/contains-duplicate-ii/description/
	// 时间复杂度: O(n)
	// 空间复杂度: O(k)

	public boolean containsNearbyDuplicate(int[] nums, int k)
	{

		if (nums == null || nums.length <= 1)
			return false;

		if (k <= 0)
			return false;

		// nums = [1,2,3,4,1], k = 3
		// nums = [1,2,3,1,2,3], k = 2
		HashSet<Integer> record = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++)
		{
			if (record.contains(nums[i]))
				return true;

			record.add(nums[i]);

			// 当map的大小大于k+1,那就减去最左边的元素
			if (record.size() == k + 1)
				record.remove(nums[i - k]);
		}

		return false;
	}

}
