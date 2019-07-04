package LeetCode;

public class LeetCode3
{

	// https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/description/
	// 滑动窗口
	// 时间复杂度: O(len(s))
	// 空间复杂度: O(len(charset))
	public int lengthOfLongestSubstring(String s)
	{

		int[] freq = new int[256];

		int l = 0, r = -1; // 滑动窗口为s[l...r]
		int res = 0;

		// 整个循环从 l == 0; r == -1 这个空窗口开始
		// 到l == s.size(); r == s.size()-1 这个空窗口截止
		// 在每次循环里逐渐改变窗口, 维护freq, 并记录当前窗口中是否找到了一个新的最优值
		while (l < s.length())
		{
			if (r + 1 < s.length() && freq[s.charAt(r + 1)] == 0)
				freq[s.charAt(++r)]++;
			else // r已经到头 || freq[s[r+1]] == 1
				freq[s.charAt(l++)]--;

			res = Math.max(res, r - l + 1);
		}

		return res;
	}

	public int lengthOfLongestSubstring2(String s)
	{

		int[] freq = new int[256];

		int l = 0, r = -1; // 滑动窗口为s[l...r]
		int res = 0;

		// 在这里, 循环中止的条件可以是 r + 1 < s.length(), 想想看为什么?
		// 感谢课程QQ群 @千千 指出 :)
		while (r + 1 < s.length())
		{

			if (r + 1 < s.length() && freq[s.charAt(r + 1)] == 0)
				freq[s.charAt(++r)]++;
			else // freq[s[r+1]] == 1
				freq[s.charAt(l++)]--;

			res = Math.max(res, r - l + 1);
		}

		return res;
	}

	// 滑动窗口的另一个实现, 仅做参考
	// 时间复杂度: O(len(s))
	// 空间复杂度: O(len(charset))
	public int lengthOfLongestSubstring3(String s)
	{

		int[] freq = new int[256];

		int l = 0, r = -1; // 滑动窗口为s[l...r]
		int res = 0;

		while (r + 1 < s.length())
		{

			while (r + 1 < s.length() && freq[s.charAt(r + 1)] == 0)
				freq[s.charAt(++r)]++;

			res = Math.max(res, r - l + 1);

			if (r + 1 < s.length())
			{
				freq[s.charAt(++r)]++;
				assert (freq[s.charAt(r)] == 2);
				while (l <= r && freq[s.charAt(r)] == 2)
					freq[s.charAt(l++)]--;
			}
		}

		return res;
	}

}
