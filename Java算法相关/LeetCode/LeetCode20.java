package LeetCode;

import java.util.Stack;

public class LeetCode20
{

	// 20. Valid Parentheses
	// https://leetcode.com/problems/valid-parentheses/description/
	// 时间复杂度: O(n)
	// 空间复杂度: O(n)

	public boolean isValid(String s)
	{

		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++)
			if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
				stack.push(s.charAt(i));
			else
			{

				if (stack.size() == 0)
					return false;
				Character c = stack.pop();

				Character match;
				if (s.charAt(i) == ')')
					match = '(';
				else if (s.charAt(i) == ']')
					match = '[';
				else
				{
					assert s.charAt(i) == '}';
					match = '{';
				}

				if (c != match)
					return false;
			}

		if (stack.size() != 0)
			return false;

		return true;
	}
}
