package LeetCode;

import java.util.HashSet;
import java.util.Set;

class LeetCode804
{
	private String[] morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
			"--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };

	public int uniqueMorseRepresentations(String[] words)
	{
		Set<String> set = new HashSet<>();
		for (String word : words)
		{
			set.add(getMorse(word));
		}
		return set.size();
	}

	// 将每个字符翻译成摩斯密码
	private String getMorse(String str)
	{
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++)
		{
			sb.append(morse[str.charAt(i) - 'a']);
		}
		return sb.toString();
	}
}
