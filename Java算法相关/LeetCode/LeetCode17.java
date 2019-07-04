package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode17
{

	/// 17. Letter Combinations of a Phone Number
	/// https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
	/// 时间复杂度: O(2^len(s))
	/// 空间复杂度: O(len(s))

	private String letterMap[] = { " ", // 0
			"", // 1
			"abc", // 2
			"def", // 3
			"ghi", // 4
			"jkl", // 5
			"mno", // 6
			"pqrs", // 7
			"tuv", // 8
			"wxyz" // 9
	};

	private ArrayList<String> res;

	public List<String> letterCombinations(String digits)
	{

		res = new ArrayList<>();

		if (digits.equals(""))
			return res;

		findCombination(digits, 0, "");
		return res;
	}

	// s中保存了此时从digits[0...index-1]翻译得到的一个字母字符串
	// 寻找和digits[index]匹配的字母, 获得digits[0...index]翻译得到的解
	private void findCombination(String digits, int index, String s)
	{

		if (index == digits.length())
		{
			res.add(s);
			return;
		}

		Character c = digits.charAt(index);
		String letters = letterMap[c - '0'];
		for (int i = 0; i < letters.length(); i++)
		{
			findCombination(digits, index + 1, s + letters.charAt(i));
		}
		return;
	}

	private static void printList(List<String> list)
	{
		for (String s : list)
			System.out.println(s);
	}

	public static void main(String[] args)
	{

		printList((new LeetCode17()).letterCombinations("234"));

	}

}
