package LeetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

import javafx.util.Pair;

public class LeetCode347
{

	// 347. Top K Frequent Elements
	// https://leetcode.com/problems/top-k-frequent-elements/description/
	// 时间复杂度: O(nlogk)
	// 空间复杂度: O(n + k)

	private class PairComparator implements Comparator<Pair<Integer, Integer>>
	{

		@Override
		public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2)
		{
			if (p1.getKey() != p2.getKey())
				return p1.getKey() - p2.getKey();
			return p1.getValue() - p2.getValue();
		}
	}

	// nums = [1,1,1,2,2,3], k = 2
	public List<Integer> topKFrequent(int[] nums, int k)
	{

		if (k <= 0)
			throw new IllegalArgumentException("k should be greater than 0");

		// 统计每个元素出现的频率
		HashMap<Integer, Integer> freq = new HashMap<>();
		for (int i = 0; i < nums.length; i++)
			if (freq.containsKey(nums[i]))
				freq.put(nums[i], freq.get(nums[i]) + 1);
			else
				freq.put(nums[i], 1);

		if (k > freq.size())
			throw new IllegalArgumentException("k should be less than the number of unique numbers in nums");

		// 扫描freq,维护当前出现频率最高的k个元素
		// 在优先队列中,按照频率排序,所以数据对是 (频率,元素) 的形式

		// 这里的是最小队列
		PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(new PairComparator());
		for (Integer num : freq.keySet())
		{
			int numFreq = freq.get(num);

			// 维护k个值，当前元素比优先队列出现的频率要高，那就出队！
			if (pq.size() == k)
			{
				if (numFreq > pq.peek().getKey())
				{
					pq.poll();
					pq.add(new Pair(numFreq, num));
				}
			} else
				pq.add(new Pair(numFreq, num));

		}

		ArrayList<Integer> res = new ArrayList<>();
		while (!pq.isEmpty())
			res.add(pq.poll().getValue());

		return res;
	}

	public static void main(String[] args)
	{
		int[] nums = { 1, 1, 1, 2, 2, 3 };

		new LeetCode347().topKFrequent(nums, 2);

	}

}
