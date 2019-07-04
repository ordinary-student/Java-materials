package LeetCode;

//https://leetcode.com/problems/sort-colors/description/
public class Leetcode75
{

	/**
	 * 扫描出现的频率，然后根据频率再填充回去
	 *
	 * @param nums
	 */
	// 时间复杂度: O(n)
	// 空间复杂度: O(1)
	public void sortColors(int[] nums)
	{
		int[] count = { 0, 0, 0 }; // 存放0, 1, 2三个元素的频率
		for (int i = 0; i < nums.length; i++)
		{
			assert nums[i] >= 0 && nums[i] <= 2;
			count[nums[i]]++;
		}
		int index = 0;
		for (int i = 0; i < count[0]; i++)
			nums[index++] = 0;
		for (int i = 0; i < count[1]; i++)
			nums[index++] = 1;
		for (int i = 0; i < count[2]; i++)
			nums[index++] = 2;
	}

	/**
	 * 三路快排思路
	 *
	 * @param nums
	 */
	// 时间复杂度: O(n)
	// 空间复杂度: O(1)
	public void sortColors2(int[] nums)
	{

		int zero = -1; // [0...zero] == 0
		int two = nums.length; // [two...n-1] == 2
		for (int i = 0; i < two;)
		{
			if (nums[i] == 1)
				i++;
			else if (nums[i] == 2)
				swap(nums, i, --two);
			else
			{ // nums[i] == 0
				assert nums[i] == 0;
				swap(nums, ++zero, i++);
			}
		}
	}

	private void swap(int[] nums, int i, int j)
	{
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}
}
