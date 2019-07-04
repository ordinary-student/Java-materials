package LeetCode;

import java.util.HashSet;

public class LeetCode349
{

	// https://leetcode.com/problems/intersection-of-two-arrays/description/

	// 时间复杂度: O(nlogn)
	// 空间复杂度: O(n)
	public int[] intersection(int[] nums1, int[] nums2)
	{

		HashSet<Integer> record = new HashSet<Integer>();
		for (int num : nums1)
			record.add(num);

		HashSet<Integer> resultSet = new HashSet<Integer>();
		for (int num : nums2)
			if (record.contains(num))
				resultSet.add(num);

		int[] res = new int[resultSet.size()];
		int index = 0;
		for (Integer num : resultSet)
			res[index++] = num;

		return res;
	}

}
