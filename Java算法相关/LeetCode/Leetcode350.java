package LeetCode;

import java.util.ArrayList;
import java.util.TreeMap;

public class Leetcode350
{

	// https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
	// 时间复杂度: O(nlogn)
	// 空间复杂度: O(n)

	public int[] intersect(int[] nums1, int[] nums2)
	{

		TreeMap<Integer, Integer> record = new TreeMap<Integer, Integer>();

		// 遍历nums1，放入map中，value是频率
		for (int num : nums1)
			if (!record.containsKey(num))
				record.put(num, 1);
			else
				record.put(num, record.get(num) + 1);

		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int num : nums2)
			if (record.containsKey(num) && record.get(num) > 0)
			{
				result.add(num);
				record.put(num, record.get(num) - 1);
			}

		int[] ret = new int[result.size()];
		int index = 0;
		for (Integer num : result)
			ret[index++] = num;

		return ret;
	}

}
