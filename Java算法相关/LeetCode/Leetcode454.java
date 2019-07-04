package LeetCode;

import java.util.HashMap;

public class Leetcode454
{

	// https://leetcode.com/problems/4sum-ii/description/
	// 时间复杂度: O(n^2)
	// 空间复杂度: O(n^2)

	public int fourSumCount(int[] A, int[] B, int[] C, int[] D)
	{

		if (A == null || B == null || C == null || D == null)
			throw new IllegalArgumentException("Illegal argument");

		// 计算C和D的sum，放入Map，如果sum重复的话，value加1
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < C.length; i++)
			for (int j = 0; j < D.length; j++)
			{
				int sum = C[i] + D[j];
				if (map.containsKey(sum))
					map.put(sum, map.get(sum) + 1);
				else
					map.put(sum, 1);
			}

		// 1.A+B+C+D=0---->A+B+Z=0--->A+B=-Z-->Z=-(A+B);
		int res = 0;
		for (int i = 0; i < A.length; i++)
			for (int j = 0; j < B.length; j++)
				if (map.containsKey(-A[i] - B[j]))
					res += map.get(-A[i] - B[j]);

		return res;
	}

	// 时间复杂度: O(n^2)
	// 空间复杂度: O(n^2)
	public int fourSumCount2(int[] A, int[] B, int[] C, int[] D)
	{

		if (A == null || B == null || C == null || D == null)
			throw new IllegalArgumentException("Illegal argument");

		HashMap<Integer, Integer> mapAB = new HashMap<Integer, Integer>();
		for (int i = 0; i < A.length; i++)
			for (int j = 0; j < B.length; j++)
			{
				int sum = A[i] + B[j];
				if (mapAB.containsKey(sum))
					mapAB.put(sum, mapAB.get(sum) + 1);
				else
					mapAB.put(sum, 1);
			}

		HashMap<Integer, Integer> mapCD = new HashMap<Integer, Integer>();
		for (int i = 0; i < C.length; i++)
			for (int j = 0; j < D.length; j++)
			{
				int sum = C[i] + D[j];
				if (mapCD.containsKey(sum))
					mapCD.put(sum, mapCD.get(sum) + 1);
				else
					mapCD.put(sum, 1);
			}

		int res = 0;
		for (Integer sumab : mapAB.keySet())
		{
			if (mapCD.containsKey(-sumab))

				res += mapAB.get(sumab) * mapCD.get(-sumab);
		}

		return res;
	}

	public static void main(String[] args)
	{

		int[] a = { 1, 2 };
		int[] b = { -2, -1 };
		int[] c = { -1, 2 };
		int[] d = { 0, 2 };
		System.out.println((new Leetcode454()).fourSumCount(a, b, c, d));
	}
}
