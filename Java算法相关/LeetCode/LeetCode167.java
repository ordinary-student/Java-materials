package LeetCode;

public class LeetCode167
{

	/**
	 * 暴力解法
	 *
	 * @param numbers
	 * @param target
	 * @return
	 */
	// 时间复杂度: O(n^2)
	// 空间复杂度: O(1)
	public int[] twoSum(int[] numbers, int target)
	{

		if (numbers.length < 2 /* || !isSorted(numbers) */)
			throw new IllegalArgumentException("Illegal argument numbers");

		for (int i = 0; i < numbers.length; i++)
			for (int j = i + 1; j < numbers.length; j++)
				if (numbers[i] + numbers[j] == target)
				{
					int[] res = { i + 1, j + 1 };
					return res;
				}

		throw new IllegalStateException("The input has no solution");
	}

	// 二分搜索法
	// 时间复杂度: O(nlogn)
	// 空间复杂度: O(1)
	public int[] twoSum2(int[] numbers, int target)
	{

		if (numbers.length < 2 /* || !isSorted(numbers) */)
			throw new IllegalArgumentException("Illegal argument numbers");
		for (int i = 0; i < numbers.length - 1; i++)
		{
			int j = binarySearch(numbers, i + 1, numbers.length - 1, target - numbers[i]);
			if (j != -1)
			{
				// 返回的数从1开始，所以下面都+1了
				int[] res = { i + 1, j + 1 };
				return res;
			}
		}

		throw new IllegalStateException("The input has no solution");
	}

	private int binarySearch(int[] nums, int l, int r, int target)
	{

		if (l < 0 || l > nums.length)
			throw new IllegalArgumentException("l is out of bound");

		if (r < 0 || r > nums.length)
			throw new IllegalArgumentException("r is out of bound");

		while (l <= r)
		{
			int mid = l + (r - l) / 2;
			if (nums[mid] == target)
				return mid;
			if (target > nums[mid])
				l = mid + 1;
			else
				r = mid - 1;
		}

		return -1;
	}

	// 对撞指针
	// 时间复杂度: O(n)
	// 空间复杂度: O(1)
	public int[] twoSum3(int[] numbers, int target)
	{

		if (numbers.length < 2 /* || !isSorted(numbers) */)
			throw new IllegalArgumentException("Illegal argument numbers");

		int l = 0, r = numbers.length - 1;
		while (l < r)
		{

			if (numbers[l] + numbers[r] == target)
			{
				int[] res = { l + 1, r + 1 };
				return res;
			} else if (numbers[l] + numbers[r] < target)
				l++;
			else // numbers[l] + numbers[r] > target
				r--;
		}

		throw new IllegalStateException("The input has no solution");
	}

}
